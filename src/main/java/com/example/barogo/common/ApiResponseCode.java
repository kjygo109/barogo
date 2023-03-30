package com.example.barogo.common;

import lombok.Getter;

@Getter
public enum ApiResponseCode {

  MEMBER_JOIN_FAILED("MEMBER_JOIN_FAILED", "회원가입 실패"),
  MEMBER_ID_DUPLICATE("MEMBER_ID_DUPLICATE", "중복된 아이디입니다."),
  MEMBER_PASSWORD_LENGTH_EX("MEMBER_PASSWORD_LENGTH_EX", "비밀번호가 12자리 미만입니다."),
  MEMBER_PASSWORD_PATTEN_EX("MEMBER_PASSWORD_PATTEN_EX", "비밀번호 규칙에 어긋납니다.(비밀번호는 영어 대문자, 영어 소문자, 숫자, 특수문자 중 3종류 이상)"),
  MEMBER_NOT_FOUND("MEMBER_NOT_FOUND", "회원정보를 찾을 수 없습니다."),
  MEMBER_NOT_VERIFY_PASSWORD("MEMBER_NOT_VERIFY_PASSWORD", "비밀번호가 틀렸습니다.")
  ;

  private final String code;
  private final String msg;

  ApiResponseCode(String code, String msg) {
    this.code = code;
    this.msg = msg;
  }
}