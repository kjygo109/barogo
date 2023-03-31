package com.example.barogo.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse<T> {

  private final boolean success;// 요청에 대한 성공/실패 여부
  private T data;         // 요청 데이터
  private String message; // 응답 메세지(에러 발생 시)
  private String code;    // 응답 코드(성공 시 null)

  public ApiResponse(boolean success) {
    this.success = success;
  }

  public ApiResponse(boolean success, String message) {
    this.success = success;
    this.message = message;
  }

  public ApiResponse(boolean success, T data) {
    this.success = success;
    this.data = data;
  }
}
