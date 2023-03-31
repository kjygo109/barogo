package com.example.barogo.test;

import com.example.barogo.domain.agency.dto.AgencyDto;
import com.example.barogo.domain.agency.dto.AgencyRequestDto;
import com.example.barogo.domain.agency.service.AgencyService;
import com.example.barogo.domain.commonCode.dto.CommonCodeDto;
import com.example.barogo.domain.commonCode.dto.CommonCodeRequestDto;
import com.example.barogo.domain.commonCode.service.CommonCodeService;
import com.example.barogo.domain.model.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestService {

  private final TestDao testDao;
  private final CommonCodeService commonCodeServiceImpl;
  private final AgencyService agencyServiceImpl;

  public void test() {
    List<Member> members = testDao.searchTest();
    System.out.println(members.get(0).getName());
    CommonCodeDto commonCodeDto = commonCodeServiceImpl.searchCommonCode(CommonCodeRequestDto.builder().codeDiv("DELIVERY_STATUS").codeKey("READY").build());
    System.out.println(commonCodeDto.getCodeKey());

    AgencyDto agencyDto = agencyServiceImpl.searchAgency(AgencyRequestDto.builder().pk(1).build());
    System.out.println(agencyDto.getName());
  }
}
