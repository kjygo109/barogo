package com.example.barogo.domain.member.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberLoginRequest {

  private String id;
  private String password;
}
