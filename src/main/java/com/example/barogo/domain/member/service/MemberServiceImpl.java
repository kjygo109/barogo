package com.example.barogo.domain.member.service;

import com.example.barogo.common.ApiException;
import com.example.barogo.common.ApiResponse;
import com.example.barogo.domain.member.dao.MemberDao;
import com.example.barogo.domain.member.dto.MemberJoinRequest;
import com.example.barogo.domain.member.dto.MemberLoginRequest;
import com.example.barogo.domain.member.dto.MemberTokenResponse;
import com.example.barogo.domain.model.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

import static com.example.barogo.common.ApiResponseCode.*;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

  private final MemberDao memberDao;

  private final PasswordEncoder passwordEncoder;

  /**
   * 회원가입
   */
  @Override
  public ApiResponse<?> joinMember(MemberJoinRequest memberJoinRequest) {

    Member member = memberJoinRequest.toMember();

    // 아이디 중복 체크
    checkId(member);

    // 비밀번호 체크
    checkPassword(member);

    // 비밀번호 암호화
    encryptPassword(member);

    try {

      memberDao.insertMember(member);
    } catch (Exception e) {
      throw new ApiException(MEMBER_JOIN_FAILED);
    }

    return new ApiResponse<>(true);
  }

  /**
   * 로그인
   */
  @Override
  public ApiResponse<?> loginMember(MemberLoginRequest memberLoginRequest) {

    Member member = Optional.ofNullable(memberDao.searchMemberById(memberLoginRequest.getId())).orElseThrow(() -> new ApiException(MEMBER_NOT_FOUND));

    verifyPassword(memberLoginRequest.getPassword(), member.getPassword());

    MemberTokenResponse memberTokenresponse = new MemberTokenResponse(member);

    return new ApiResponse<>(true, memberTokenresponse);
  }

  /**
   * 아이디 중복 체크
   */
  private void checkId(Member member) {

    if (!Objects.isNull(memberDao.searchMemberById(member.getId()))) {
      throw new ApiException(MEMBER_ID_DUPLICATE);
    }
  }

  /**
   * 비밀번호 패턴 체크
   */
  private void checkPassword(Member member) {

    String password = member.getPassword();

    if (password.length() < 12) throw new ApiException(MEMBER_PASSWORD_LENGTH_EX);

    int cnt = 0;

    if (password.matches("(?=.*[A-Z]).+")) cnt++; // 대문자 체크
    if (password.matches("(?=.*[a-z]).+")) cnt++; // 소문자 체크
    if (password.matches("(?=.*[0-9]).+")) cnt++; // 숫자 체크
    if (password.matches("(?=.*[!@#$%^&*]).+")) cnt++; // 특수문자 (!@#$%^&*) 체크

    if (cnt < 3) throw new ApiException(MEMBER_PASSWORD_PATTEN_EX);
  }

  /**
   * 비밀번호 암호화
   */
  private void encryptPassword(Member member) {

    member.setPassword(passwordEncoder.encode(member.getPassword()));
  }

  /**
   * 비밀번호 검증
   */
  private void verifyPassword(String rawPassword, String encodedPassword) {

    if (!passwordEncoder.matches(rawPassword, encodedPassword)) throw new ApiException(MEMBER_NOT_VERIFY_PASSWORD);
  }
}
