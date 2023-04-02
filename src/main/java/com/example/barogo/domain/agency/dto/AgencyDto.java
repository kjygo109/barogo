package com.example.barogo.domain.agency.dto;

import com.example.barogo.domain.model.Agency;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Getter
public class AgencyDto {

  private final Map<Integer, InnerAgency> agencyMap = new HashMap<>();

  public AgencyDto(List<Agency> agency) {
    this.agencyMap.putAll(agency.stream().map(InnerAgency::new)
            .collect(Collectors.toMap(InnerAgency::getPk, Function.identity())));
  }

  @Getter
  public static class InnerAgency {

    private final int pk;
    private final String name;
    private final String address;

    public InnerAgency(Agency agency) {

      this.pk = agency.getPk();
      this.name = agency.getName();
      this.address = agency.getAddress();
    }
  }
}
