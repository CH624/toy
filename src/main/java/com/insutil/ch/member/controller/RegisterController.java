package com.insutil.ch.member.controller;

import com.insutil.ch.common.response.OperationResponse;
import com.insutil.ch.member.model.Member;
import com.insutil.ch.member.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RegisterController {
    private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);
    private final RegisterService registerService;

    @GetMapping("/register/check")
    public boolean checkForDuplicateLoginId(String loginId){
        logger.info("RegisterController.checkForDuplicateLoginId()" + loginId);
        return registerService.checkForDuplicateLoginId(loginId);
    }

    @PostMapping("/register")
    public ResponseEntity<OperationResponse> register(@RequestBody Member member){
        logger.info("RegisterController.register");
        OperationResponse response = registerService.operationAndMakeResponse(registerService.insertMember(member));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
