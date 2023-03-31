package com.example.barogo.domain.commonCode.dto;

import com.example.barogo.domain.model.CommonCode;
import lombok.Getter;

@Getter
public class CommonCodeDto {

  private final int pk;
  private final String codeDiv;
  private final String codeKey;
  private final String codeVal;

  public CommonCodeDto(CommonCode commonCode) {

    this.pk = commonCode.getPk();
    this.codeDiv = commonCode.getCodeDiv();
    this.codeKey = commonCode.getCodeKey();
    this.codeVal = commonCode.getCodeVal();
  }
}
