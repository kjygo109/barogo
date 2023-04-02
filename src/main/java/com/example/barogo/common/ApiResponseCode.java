package com.example.barogo.common;

import lombok.Getter;

@Getter
public enum ApiResponseCode {

  MEMBER_JOIN_FAILED("MEMBER_JOIN_FAILED", "회원가입 실패"),
  MEMBER_ID_DUPLICATE("MEMBER_ID_DUPLICATE", "중복된 아이디입니다."),
  MEMBER_PASSWORD_LENGTH_EX("MEMBER_PASSWORD_LENGTH_EX", "비밀번호가 12자리 미만입니다."),
  MEMBER_PASSWORD_PATTEN_EX("MEMBER_PASSWORD_PATTEN_EX", "비밀번호 규칙에 어긋납니다.(비밀번호는 영어 대문자, 영어 소문자, 숫자, 특수문자 중 3종류 이상)"),
  MEMBER_NOT_FOUND("MEMBER_NOT_FOUND", "회원정보를 찾을 수 없습니다."),
  MEMBER_NOT_VERIFY_PASSWORD("MEMBER_NOT_VERIFY_PASSWORD", "비밀번호가 틀렸습니다."),
  MEMBER_PK_EMPTY("MEMBER_PK_EX", "멤버정보(memberPk)가 없습니다."),
  DELIVERY_ADDRESS_EMPTY("DELIVERY_ADDRESS_EMPTY", "배달주소(deliveryAddress)가 없습니다."),
  ITEMS_EMPTY("ITEMS_EMPTY", "상품(ITEM)이 없습니다."),
  ITEMS_SEARCH_EX("ITEMS_SEARCH_EX", "조회되지 않는 상품이 존재합니다. items 를 확인해주세요"),
  ORDER_FAILED("ORDER_FAILED", "주문 실패"),
  DATE_FORMAT_EX("DATE_FORMAT_EX", "날짜 포맷 변환에 실패했습니다. yyyy-MM-dd HH:mm:ss 포맷(startAt, endAt)으로 조회해주세요."),
  START_AT_EMPTY("START_AT_EMPTY", "시작날짜(startAt)가 비어있습니다."),
  END_AT_EMPTY("END_AT_EMPTY", "종료날짜(endAt)가 비어있습니다."),
  START_AT_END_AT_EX("START_AT_END_AT_EX", "시작날짜가 종료날짜보다 미래입니다."),
  DATE_OVER_EX("DATE_OVER_EX", "날짜범위(3일)가 초과하였습니다."),
  UPDATE_ORDER_ADDRESS_EX("UPDATE_ORDER_ADDRESS_EX", "주소 변경 실패"),
  DELIVERY_STATUS_EX("DELIVERY_STATUS_EX", "배달 섭외중일때만 변경 가능합니다."),
  ORDER_PK_EMPTY("ORDER_PK_EMPTY", "주문정보(orderPk)가 없습니다.");

  private final String code;
  private final String msg;

  ApiResponseCode(String code, String msg) {
    this.code = code;
    this.msg = msg;
  }
}
