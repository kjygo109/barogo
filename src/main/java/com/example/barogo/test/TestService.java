package com.example.barogo.test;

import com.example.barogo.domain.model.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestService {

  private final TestDao testDao;

  public void test() {
    List<Member> members = testDao.searchTest();
    System.out.println(members.get(0).getName());
  }
}
