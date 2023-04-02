package com.example.barogo.domain.commonCode.dto;

import com.example.barogo.domain.model.CommonCode;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Getter
public class CommonCodeDto {

  private final Map<String, InnerCommonCode> commonCodeMap = new HashMap<>();

  public CommonCodeDto(List<CommonCode> commonCode) {
    this.commonCodeMap.putAll(commonCode.stream().map(InnerCommonCode::new)
            .collect(Collectors.toMap(InnerCommonCode::getCodeKey, Function.identity())));
  }

  @Getter
  public static class InnerCommonCode {

    private final int pk;
    private final String codeDiv;
    private final String codeKey;
    private final String codeVal;

    public InnerCommonCode(CommonCode commonCode) {

      this.pk = commonCode.getPk();
      this.codeDiv = commonCode.getCodeDiv();
      this.codeKey = commonCode.getCodeKey();
      this.codeVal = commonCode.getCodeVal();
    }
  }
}
