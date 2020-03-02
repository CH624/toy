package com.insutil.ch.member.model;

import com.insutil.ch.common.util.SHA256PasswordUtil;
import com.insutil.ch.member.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MemberTest {
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private SHA256PasswordUtil sha256PasswordUtil;

    @Test
    public void memberInsertTest() throws Exception{
        Member member = new Member();
        member.setLoginId("ch624");
        member.setPassword(sha256PasswordUtil.getPassword("1234"));
        member.setAge(28);
        member.setName("정채현");
        memberRepository.save(member);
    }

    @Test
    public void getMember(){
        memberRepository.findAll().forEach(System.out::println);
    }

    @Test
    public void member(){

    }
}