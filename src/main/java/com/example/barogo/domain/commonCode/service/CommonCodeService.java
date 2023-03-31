package com.example.barogo.domain.commonCode.service;

import com.example.barogo.domain.commonCode.dto.CommonCodeDto;
import com.example.barogo.domain.commonCode.dto.CommonCodeRequestDto;

public interface CommonCodeService {

  CommonCodeDto searchCommonCode(CommonCodeRequestDto commonCodeRequestDto);
}
