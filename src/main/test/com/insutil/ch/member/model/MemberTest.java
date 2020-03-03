package com.insutil.ch.member.model;

import com.insutil.ch.member.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MemberTest {
    @Autowired
    private MemberRepository memberRepository;
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Test
    public void memberInsertTest() {
        Member member = new Member();
        member.setLoginId("ch624");
        member.setPassword(passwordEncoder.encode("1234"));
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