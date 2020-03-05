package com.insutil.ch.member.model;

import com.insutil.ch.member.repository.MemberRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MemberTest {
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private EntityManager entityManager;
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Test
    public void memberInsertTest() {
        Member member = new Member();
        member.setLoginId("temp1");
        member.setPassword(passwordEncoder.encode("1234"));
        member.setName("정채현");
        memberRepository.save(member);
    }

    @Test
    public void getMemberList(){
        memberRepository.findAll().forEach(System.out::println);
    }

    @Test
    @Transactional
    public void getMember(){
        Member member1 = entityManager.find(Member.class, 1L);
        Member member2 = entityManager.find(Member.class, 1L);
        System.out.println("member1.hashCode() : " + member1.hashCode());
        System.out.println("member2.hashCode() : " + member2.hashCode());
        System.out.println("member1 == member2 : " + (member1 == member2));
        System.out.println(member1.getRoles());
    }
}