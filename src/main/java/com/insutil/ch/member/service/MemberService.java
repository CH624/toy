package com.insutil.ch.member.service;

import com.insutil.ch.common.response.OperationAndMakeResponse;
import com.insutil.ch.member.model.Member;
import com.insutil.ch.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService implements OperationAndMakeResponse{
    private static final Logger logger = LoggerFactory.getLogger(MemberService.class);
    private final MemberRepository memberRepository;

    public List<Member> getMemberList() {
        logger.info("MemberService.getMemberList()");
        return memberRepository.findAll();
    }

    public Member getMemberByName(String name){
        return memberRepository.findByName(name);
    }

    public Member getMemberByLoginId(String loginId){
        return memberRepository.findByLoginId(loginId);
    }

    public boolean checkMemberByName(String name){
        return Optional.ofNullable(memberRepository.findByName(name)).isPresent();
    }
}
