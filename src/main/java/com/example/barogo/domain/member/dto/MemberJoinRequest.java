package com.example.barogo.domain.member.dto;

import com.example.barogo.domain.model.Member;
import lombok.Getter;

@Getter
public class MemberJoinRequest {

  private String id;
  private String name;
  private String password;

  public Member toMember() {
    return Member.builder()
            .id(this.id)
            .name(this.name)
            .password(this.password)
            .build();
  }
}
