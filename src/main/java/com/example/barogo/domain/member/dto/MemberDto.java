package com.example.barogo.domain.member.dto;

import com.example.barogo.domain.model.Member;
import lombok.Getter;

@Getter
public class MemberDto {

  private int pk;
  private String id;
  private String name;
  private String password;
}
