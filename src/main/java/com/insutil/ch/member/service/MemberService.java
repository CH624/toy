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

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService implements OperationAndMakeResponse{
    private static final Logger logger = LoggerFactory.getLogger(MemberService.class);
    private final MemberRepository memberRepository;

    public List<Member> getMemberList(){
        logger.info("MemberService.getMemberList()");
        return memberRepository.findAll();
    }
}
