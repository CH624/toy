package com.insutil.ch.common.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class CommonController {
    private static final Logger logger = LoggerFactory.getLogger(CommonController.class);

    @GetMapping({"/", ""})
    public ModelAndView index(ModelAndView mv){
        logger.info("CommonController.index()");
        mv.addObject("wrapName", "main");
        mv.setViewName("/index");
        return mv;
    }

    @GetMapping("/login")
    public ModelAndView login(ModelAndView mv){
        logger.info("CommonController.login()");
        mv.setViewName("/common/login");
        return mv;
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
