package com.insutil.ch.common.controller;

import com.insutil.ch.common.response.ContentResponse;
import com.insutil.ch.common.response.OperationResponse;
import com.insutil.ch.member.model.Member;
import com.insutil.ch.member.repository.MemberRepository;
import com.insutil.ch.security.config.JwtTokenProvider;
import com.insutil.ch.security.model.Authority;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class CommonController {
    private static final Logger logger = LoggerFactory.getLogger(CommonController.class);
    private final MemberRepository memberRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<OperationResponse> login(@RequestBody Member loginMember){
        Member member = Optional.ofNullable(memberRepository.findByLoginId(loginMember.getLoginId()))
                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 ID 입니다."));
        if (!passwordEncoder.matches(loginMember.getPassword(), member.getPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }

        ContentResponse<String> response = new ContentResponse<>(OperationResponse.ResponseStatusEnum.SUCCESS, "SUCCESS");
        response.setContent(jwtTokenProvider.createToken(member.getLoginId(), member.getRoles().stream().map(Authority::getAuthority).collect(Collectors.toList())));
        logger.info("Login(user: " + loginMember.getLoginId() + ")");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
