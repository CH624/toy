package com.insutil.ch.member.controller;

import com.insutil.ch.common.response.OperationResponse;
import com.insutil.ch.member.model.Member;
import com.insutil.ch.member.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class RegisterController {
    private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);
    private final RegisterService registerService;

    @GetMapping("/register")
    public ModelAndView register(ModelAndView mv){
        logger.info("RegisterController.register()");
        mv.setViewName("/user/register");
        return mv;
    }

    @PostMapping("/api/register")
    @ResponseBody
    public ResponseEntity<OperationResponse> insertMember(Member member) {
        logger.info("RegisterController.insertMember()");
        registerService.insertMember(member);
        return new ResponseEntity<>(registerService.operationAndMakeResponse(true), HttpStatus.OK);
    }

    @GetMapping("/api/register/check")
    @ResponseBody
    public boolean checkForDuplicateLoginId(Member member){
        logger.info("RegisterController.checkForDuplicateLoginId()" + member.getLoginId());
        return registerService.checkForDuplicateLoginId(member);
    }
}
