package com.example.barogo.config;

import com.example.barogo.domain.member.dao.MemberDao;
import com.example.barogo.domain.model.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ApiUserDetailsService implements UserDetailsService {

  private final MemberDao memberDao;

  @Override
  public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

    Member member = memberDao.searchMemberById(userName);
    List<GrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority("member"));

    return new ApiUserDetails(member, authorities);
  }
}
