package com.example.barogo.test;

import com.example.barogo.domain.model.Member;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TestDao {

  List<Member> searchTest();
}
