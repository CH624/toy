package com.insutil.ch.blog.controller;

import com.insutil.ch.blog.service.BlogService;
import com.insutil.ch.blog.service.BlogSettingService;
import com.insutil.ch.member.model.Member;
import com.insutil.ch.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/blog")
public class BlogController {
    private static final Logger logger = LoggerFactory.getLogger(BlogController.class);
    private final BlogService blogService;
    private final BlogSettingService blogSettingService;
    private final MemberService memberService;

    @GetMapping("/{userName}")
    public ModelAndView blog(ModelAndView mv, @PathVariable String userName){
        Member member = memberService.getMemberByName(userName);
        if (Optional.ofNullable(member).isPresent()){
            mv.setViewName("/template");
            mv.addObject("wrapper", "/blog/blog");
            mv.addObject("blogSetting", blogSettingService.getBlogSetting(member));
        }else{
            mv.setViewName("redirect:/user-not-found");
        }
        return mv;
    }
}
