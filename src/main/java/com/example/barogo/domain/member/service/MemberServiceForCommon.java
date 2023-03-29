package com.example.barogo.domain.member.service;

import com.example.barogo.domain.member.dao.MemberDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceForCommon implements MemberService{

  private final MemberDao memberDao;


}
