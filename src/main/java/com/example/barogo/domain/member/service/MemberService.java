package com.example.barogo.domain.member.service;

import com.example.barogo.common.ApiResponse;
import com.example.barogo.domain.member.dto.MemberJoinRequest;
import com.example.barogo.domain.member.dto.MemberLoginRequest;

public interface MemberService {

  ApiResponse<?> joinMember(MemberJoinRequest memberJoinRequest);

  ApiResponse<?> loginMember(MemberLoginRequest memberLoginRequest);
}
