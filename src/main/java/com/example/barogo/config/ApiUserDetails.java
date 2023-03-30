package com.example.barogo.config;

import com.example.barogo.domain.model.Member;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public class ApiUserDetails extends User {

  public ApiUserDetails(Member member, List<GrantedAuthority> authorities) {

    super(member.getName(), member.getPassword(), authorities);
  }
}
