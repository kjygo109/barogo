package com.example.barogo.domain.agency.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class AgencyRequestDto {

  private List<Integer> pks;
}
