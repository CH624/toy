package com.insutil.ch.group.model;

import com.insutil.ch.group.repository.GroupRepository;
import com.insutil.ch.member.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class GroupTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    GroupRepository groupRepository;

    @Test
    public void groupTest(){

    }

    @Test
    public void addGroup(){
        Group group = new Group();
        group.setName("인스유틸");
        groupRepository.save(group);
    }
}