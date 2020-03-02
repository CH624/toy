package com.insutil.ch.member.service;

import com.insutil.ch.common.exceptions.InsertFailException;
import com.insutil.ch.common.response.OperationAndMakeResponse;
import com.insutil.ch.common.util.LogUtil;
import com.insutil.ch.common.util.SHA256PasswordUtil;
import com.insutil.ch.member.model.Member;
import com.insutil.ch.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService implements OperationAndMakeResponse {
    private static final Logger logger = LoggerFactory.getLogger(MemberService.class);
    private final MemberRepository memberRepository;
    private final SHA256PasswordUtil sha256PasswordUtil;

    public List<Member> getMemberList(){
        logger.info("MemberService.getMemberList()");
        return memberRepository.findAll();
    }

    public Member getMember(Member member){
        logger.info("MemberService.getMember()");
        return memberRepository.findByLoginId(member.getLoginId()).orElseThrow();
    }

    public void insertMember(Member member) throws Exception{
        logger.info("MemberService.insertMember()" + member);
        member.setPassword(sha256PasswordUtil.getPassword(member.getPassword()));
        memberRepository.save(member);
    }

    public boolean checkForDuplicateLoginId(Member member) {
        logger.info("MemberService.checkForDuplicateLoginId()" + member.getLoginId());
        return memberRepository.findByLoginId(member.getLoginId()).isEmpty();
    }
}
