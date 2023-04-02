package com.example.barogo.domain.commonCode.service;

import com.example.barogo.domain.commonCode.dao.CommonCodeDao;
import com.example.barogo.domain.commonCode.dto.CommonCodeDto;
import com.example.barogo.domain.commonCode.dto.CommonCodeRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommonCodeServiceImpl implements CommonCodeService {

  private final CommonCodeDao commonCodeDao;

  /**
   * 공통코드 조회
   */
  @Override
  public CommonCodeDto searchCommonCode(CommonCodeRequestDto commonCodeRequestDto) {
    return new CommonCodeDto(commonCodeDao.searchCommonCode(commonCodeRequestDto));
  }
}
