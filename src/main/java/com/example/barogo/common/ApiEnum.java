package com.example.barogo.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class ApiEnum {

  @Getter
  @AllArgsConstructor
  public enum DELIVERY_STATUS {

    READY("READY"),
    OPERATE("OPERATE"),
    COMPLETE("COMPLETE"),
    CANCEL("CANCEL");

    private final String code;
  }
}
