package com.example.barogo.domain.agency.dao;

import com.example.barogo.domain.agency.dto.AgencyRequestDto;
import com.example.barogo.domain.model.Agency;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AgencyDao {

  Agency searchAgency(AgencyRequestDto agencyRequestDto);
}
