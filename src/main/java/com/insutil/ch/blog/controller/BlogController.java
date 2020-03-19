package com.insutil.ch.blog.controller;

import com.insutil.ch.blog.service.BlogService;
import com.insutil.ch.blog.service.BlogSettingService;
import com.insutil.ch.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/blog")
public class BlogController {
    private static final Logger logger = LoggerFactory.getLogger(BlogController.class);
    private final BlogService blogService;
    private final BlogSettingService blogSettingService;
    private final MemberService memberService;
}
