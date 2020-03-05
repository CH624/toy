package com.insutil.ch.member.service;

import com.insutil.ch.common.response.OperationAndMakeResponse;
import com.insutil.ch.member.model.Member;
import com.insutil.ch.member.repository.MemberRepository;
import com.insutil.ch.security.Model.Authority;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class RegisterService implements OperationAndMakeResponse {
    private static final Logger logger = LoggerFactory.getLogger(RegisterService.class);
    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void insertMember(Member member) {
        member.setPassword(passwordEncoder.encode(member.getPassword()));
        member.setRoles(Arrays.asList(new Authority("MEMBER")));
        memberRepository.save(member);
    }

    public boolean checkForDuplicateLoginId(Member member) {
        logger.info("RegisterService.checkForDuplicateLoginId()" + member.getLoginId());
        return Optional.ofNullable(memberRepository.findByLoginId(member.getLoginId())).isEmpty();
    }
}
