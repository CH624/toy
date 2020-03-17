package com.insutil.ch.common.controller;

import com.insutil.ch.member.model.Member;
import com.insutil.ch.member.repository.MemberRepository;
import com.insutil.ch.member.service.MemberService;
import com.insutil.ch.security.config.JwtTokenProvider;
import com.insutil.ch.security.model.Authority;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class CommonController {
    private static final Logger logger = LoggerFactory.getLogger(CommonController.class);
    private final MemberRepository memberRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    @GetMapping
    public ModelAndView index(ModelAndView mv){
        logger.info("CommonController.index()");
        mv.setViewName("/index");
        return mv;
    }

    @GetMapping("/login")
    public ModelAndView login(ModelAndView mv){
        logger.info("CommonController.login()");
        mv.setViewName("/common/login");
        return mv;
    }

    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestBody Member loginMember){
        Member member = Optional.ofNullable(memberRepository.findByLoginId(loginMember.getLoginId()))
                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 ID 입니다."));
        if (!passwordEncoder.matches(loginMember.getPassword(), member.getPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }
        return jwtTokenProvider.createToken(member.getLoginId(), member.getRoles().stream().map(Authority::getAuthority).collect(Collectors.toList()));
    }

    @GetMapping("/forgot")
    public ModelAndView forgotPassword(ModelAndView mv){
        logger.info("CommonController.forgotPassword()");
        mv.setViewName("/common/forgot-password");
        return mv;
    }

    @GetMapping("/recover")
    public ModelAndView recoverPassword(ModelAndView mv){
        logger.info("CommonController.recoverPassword()");
        mv.setViewName("/common/recover-password");
        return mv;
    }
}
