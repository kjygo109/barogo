package com.example.barogo.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Base64;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

/**
 * JWT 생성 및 검증 클래스
 */
@Component
@RequiredArgsConstructor
public class JwtUtil implements Serializable {

  private final static Logger log = LogManager.getLogger(JwtUtil.class);
  private static final long serialVersionUID = 1L;
  public static final long JWT_ACCESS_TOKEN_VALIDITY = 1000L * 60 * 60 * 5;   // 5시간만 토큰 유효

  private final UserDetailsService userDetailsService;

  @Value("${token.secret}")
  private String secretValue;

  public static String secret;

  @PostConstruct
  public void initialize() {
    secret = Base64.getEncoder().encodeToString(secretValue.getBytes());
  }


  // Access token 생성(유효기간 5시간)
  public static String generate(Map<String, Object> claims, String sub) {
    return Jwts.builder()
      .setClaims(claims)
      .setSubject(sub)
      .setIssuedAt(new Date(System.currentTimeMillis()))
      .setExpiration(new Date(System.currentTimeMillis() + JWT_ACCESS_TOKEN_VALIDITY))
      .signWith(SignatureAlgorithm.HS512, secret).compact();
  }

  public static Claims getAllClaimsFromToken(String token) {
    try {
      return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    } catch (ExpiredJwtException e) {
      throw e;
    } catch (Exception e) {
      log.info("-- 토큰 읽기 오류", e);
      throw e;
    }
  }

  public static <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
    final Claims claims = getAllClaimsFromToken(token);
    return claimsResolver.apply(claims);
  }

  public static Date getExpirationDateFromToken(String token) {
    return getClaimFromToken(token, Claims::getExpiration);
  }

  public String resolveClientToken(HttpServletRequest request) {
    return request.getHeader("Authorization");
  }

  // 토큰 만료 체크
  public Boolean isTokenExpired(String token) {
    try {
      final Date expiration = getExpirationDateFromToken(token);
      return expiration.before(new Date());
    } catch (Exception e) {
      return true;
    }
  }

  // JWT 토큰으로 인증정보 조회(클라이언트 access token)
  public Authentication getClientAuthentication(String token) {
    UserDetails userDetails = userDetailsService.loadUserByUsername(getAllClaimsFromToken(token).get("id").toString());
    return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
  }
}
