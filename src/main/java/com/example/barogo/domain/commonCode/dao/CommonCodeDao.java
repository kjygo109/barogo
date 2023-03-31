package com.example.barogo.domain.commonCode.dao;

import com.example.barogo.domain.commonCode.dto.CommonCodeRequestDto;
import com.example.barogo.domain.model.CommonCode;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface CommonCodeDao {

  CommonCode searchCommonCode(CommonCodeRequestDto commonCodeRequestDto);
}
