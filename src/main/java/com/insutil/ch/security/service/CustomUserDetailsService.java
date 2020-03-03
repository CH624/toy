package com.insutil.ch.security.service;

import com.insutil.ch.common.exceptions.DataNotFoundException;
import com.insutil.ch.member.model.Member;
import com.insutil.ch.member.repository.MemberRepository;
import com.insutil.ch.security.Model.Authority;
import com.insutil.ch.security.Model.CustomUserDetails;
import com.insutil.ch.security.repository.AuthorityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.AuthenticationException;
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

@Service
@Transactional
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final AuthorityRepository authorityRepository;
    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException{
        Member member = memberRepository.findByLoginId(loginId).orElseThrow(()-> new UsernameNotFoundException(loginId + "is not founded"));
        CustomUserDetails customUserDetails = new CustomUserDetails();
        customUserDetails.setUsername(member.getLoginId());
        customUserDetails.setPassword(member.getPassword());
        customUserDetails.setAuthorities(getAuthorities(member.getLoginId()));
        customUserDetails.setEnabled(true);
        customUserDetails.setAccountNonExpired(true);
        customUserDetails.setAccountNonLocked(true);
        customUserDetails.setCredentialsNonExpired(true);

        return customUserDetails;
    }

    public Collection<GrantedAuthority> getAuthorities(String loginId) {
        List<Authority> authList = authorityRepository.findByLoginId(loginId).orElse(new ArrayList<>());
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Authority authority : authList) {
            authorities.add(new SimpleGrantedAuthority(authority.getAuthority()));
        }
        return authorities;
    }
}
