package com.example.barogo.domain.agency.service;

import com.example.barogo.domain.agency.dto.AgencyDto;
import com.example.barogo.domain.agency.dto.AgencyRequestDto;

public interface AgencyService {

  AgencyDto searchAgency(AgencyRequestDto agencyRequestDto);
}
