package com.example.barogo.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Member {

  private int pk;
  private String id;
  private String name;
  private String password;
}
