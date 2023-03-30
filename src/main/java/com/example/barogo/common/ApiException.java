package com.example.barogo.common;

import lombok.Getter;

@Getter
public class ApiException extends RuntimeException{

  private final String code;

  public ApiException(ApiResponseCode responseCode){
    super(responseCode.getMsg());
    this.code = responseCode.getCode();
  }
}
