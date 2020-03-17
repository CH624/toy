package com.insutil.ch.common.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController {
    private static final Logger logger = LoggerFactory.getLogger(CustomErrorController.class);

    @GetMapping("/error/404")
    public String pageNotFound(){
        logger.info("404 Not Found");
        return "/error/404";
    }

    @GetMapping("/error/500")
    public String error500(){
        logger.info("500 error");
        return "/error/500";
    }

    @GetMapping("/denied")
    public String accessDenied(Authentication authentication){
        logger.info("Access denied // Login Id : " + authentication.getName());
        return "/error/denied";
    }

    @GetMapping("/user-not-found")
    public String userNotFound(){
        logger.info("user not found");
        return "/error/user-not-found";
    }
}
