package com.example.barogo.domain.member.dto;

import com.example.barogo.domain.model.Member;
import com.example.barogo.jwt.JwtUtil;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class MemberTokenResponse {

  private final String accessToken;

  public MemberTokenResponse(Member member) {
    this.accessToken = JwtUtil.generate(generateTokenClaims(member), member.getId());
  }

  private Map<String, Object> generateTokenClaims(Member member) {
    Map<String, Object> claims = new HashMap<>();
    claims.put("pk", member.getPk());
    claims.put("id", member.getId());
    claims.put("name", member.getName());
    return claims;
  }
}
