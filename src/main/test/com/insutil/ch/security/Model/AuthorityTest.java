package com.insutil.ch.security.Model;

import com.insutil.ch.security.repository.AuthorityRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AuthorityTest {

    @Autowired
    AuthorityRepository authorityRepository;

    @Test
    public void authorityTest(){
        authorityRepository.findByUserId(1L).orElse(new ArrayList<>()).stream().forEach(System.out::println);
    }
}