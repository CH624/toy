package com.insutil.ch.board.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ReplyServiceTest {
    @Autowired
    ReplyService replyService;

    @Test
    public void replyServiceTest(){
        //replyService.replyTest();
        replyService.replyTest2();
    }
}