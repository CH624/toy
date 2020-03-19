package com.insutil.ch.member.service;

import com.insutil.ch.blog.model.BlogSetting;
import com.insutil.ch.blog.repository.BlogSettingRepository;
import com.insutil.ch.common.response.OperationAndMakeResponse;
import com.insutil.ch.member.model.Member;
import com.insutil.ch.member.repository.MemberRepository;
import com.insutil.ch.security.model.Authority;
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
    private final BlogSettingRepository blogSettingRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public boolean insertMember(Member member) {
        member.setPassword(passwordEncoder.encode(member.getPassword()));
        member.setRoles(Arrays.asList(new Authority("ROLE_MEMBER")));
        memberRepository.save(member);
        blogSettingRepository.save(
                BlogSetting.builder()
                .member(member)
                .title(member.getName() + "의 블로그")
                .build()
        );
        return true;
    }

    public boolean checkForDuplicateLoginId(String loginId) {
        logger.info("RegisterService.checkForDuplicateLoginId()" + loginId);
        return Optional.ofNullable(memberRepository.findByLoginId(loginId)).isEmpty();
    }
}
