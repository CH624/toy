package com.insutil.ch.member.model;

import com.insutil.ch.member.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MemberTest {
    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void memberTest(){
        memberRepository.save(new Member("ch624", "정채현", 28));
        memberRepository.save(new Member("jh123", "장현", 29));
    }
}