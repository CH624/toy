package com.insutil.ch.member.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class PasswordController {
    private static final Logger logger = LoggerFactory.getLogger(PasswordController.class);

    @GetMapping("/forgot")
    public ModelAndView forgotPassword(ModelAndView mv){
        logger.info("CommonController.forgotPassword()");
        mv.setViewName("/user/forgot-password");
        return mv;
    }

    @GetMapping("/recover")
    public ModelAndView recoverPassword(ModelAndView mv){
        logger.info("CommonController.recoverPassword()");
        mv.setViewName("/user/recover-password");
        return mv;
    }
}
