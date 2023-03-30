package com.example.barogo.domain.member.dao;

import com.example.barogo.domain.model.Member;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface MemberDao {

  Member searchMemberById(String memberId);

  void insertMember(Member member);
}
