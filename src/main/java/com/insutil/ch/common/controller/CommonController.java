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

    @GetMapping("/")
    public ModelAndView index(ModelAndView mv){
        logger.info("CommonController.index()");
        mv.setViewName("/index");
        return mv;
    }
}
