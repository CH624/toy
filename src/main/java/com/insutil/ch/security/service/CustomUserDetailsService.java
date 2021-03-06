package com.insutil.ch.security.service;

import com.insutil.ch.member.model.Member;
import com.insutil.ch.member.repository.MemberRepository;
import com.insutil.ch.security.model.Authority;
import com.insutil.ch.security.model.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException{
        Member member = Optional
                .ofNullable(memberRepository.findByLoginId(loginId))
                .orElseThrow(()-> new UsernameNotFoundException(loginId + "is not founded"));
        return CustomUserDetails.builder()
                .username(member.getLoginId())
                .password(member.getPassword())
                .authorities(getAuthorities(member.getRoles()))
                .isEnabled(true)
                .isAccountNonExpired(true)
                .isAccountNonLocked(true)
                .isCredentialsNonExpired(true)
                .build();
    }

    public Collection<GrantedAuthority> getAuthorities(List<Authority> authorityList) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Authority authority : authorityList) {
            authorities.add(new SimpleGrantedAuthority(authority.getAuthority()));
        }
        return authorities;
    }
}
