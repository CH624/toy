package com.insutil.ch.member.controller;

import com.insutil.ch.common.response.ContentResponse;
import com.insutil.ch.common.response.OperationResponse;
import com.insutil.ch.member.model.Member;
import com.insutil.ch.member.service.MemberService;
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

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
    private final MemberService memberService;

    @GetMapping("/api/member/info")
    @ResponseBody
    public ResponseEntity<OperationResponse> getMemberList(){
        logger.info("MemberController.getMemberList()");
        ContentResponse<List<Member>> response = new ContentResponse<>(OperationResponse.ResponseStatusEnum.SUCCESS, "SUCCESS");
        response.setContent(memberService.getMemberList());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
