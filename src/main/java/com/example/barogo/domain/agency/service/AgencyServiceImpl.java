package com.example.barogo.domain.agency.service;

import com.example.barogo.domain.agency.dao.AgencyDao;
import com.example.barogo.domain.agency.dto.AgencyDto;
import com.example.barogo.domain.agency.dto.AgencyRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AgencyServiceImpl implements AgencyService {

  private final AgencyDao agencyDao;

  /**
   * 업체 조회
   */
  @Override
  public AgencyDto searchAgency(AgencyRequestDto agencyRequestDto) {
    return new AgencyDto(agencyDao.searchAgency(agencyRequestDto));
  }
}
