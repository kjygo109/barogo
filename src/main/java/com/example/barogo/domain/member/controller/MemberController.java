package com.example.barogo.domain.member.controller;

import com.example.barogo.common.ApiResponse;
import com.example.barogo.domain.member.dto.MemberJoinRequest;
import com.example.barogo.domain.member.dto.MemberLoginRequest;
import com.example.barogo.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

  private final MemberService memberServiceImpl;

  @PostMapping("/join")
  public ApiResponse<?> joinMember(MemberJoinRequest memberJoinRequest) {
    return memberServiceImpl.joinMember(memberJoinRequest);
  }

  @PostMapping("/login")
  public ApiResponse<?> loginMember(MemberLoginRequest memberLoginRequest) {
    return memberServiceImpl.loginMember(memberLoginRequest);
  }
}
