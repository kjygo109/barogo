package com.example.barogo.domain.agency.dto;

import com.example.barogo.domain.model.Agency;
import lombok.Getter;

@Getter
public class AgencyDto {

  private final int pk;
  private final String name;
  private final String address;

  public AgencyDto(Agency agency) {

    this.pk = agency.getPk();
    this.name = agency.getName();
    this.address = agency.getAddress();
  }
}
