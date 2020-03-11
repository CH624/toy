package com.insutil.ch.board.model;

import com.insutil.ch.board.repository.BoardRepository;
import com.insutil.ch.board.repository.ReplyRepository;
import com.insutil.ch.member.model.Member;
import com.insutil.ch.member.repository.MemberRepository;
import com.insutil.ch.security.model.Authority;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BoardTest {

    @Autowired
    BoardRepository boardRepository;
    @Autowired
    ReplyRepository replyRepository;
    @Autowired
    MemberRepository memberRepository;

//    @Before
//    public void addMember(){
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        Member member = new Member();
//        member.setName("정채현");
//        member.setLoginId("ch624");
//        member.setPassword(bCryptPasswordEncoder.encode("12341234"));
//        member.setRoles(Arrays.asList(new Authority("ROLE_MEMBER")));
//        memberRepository.save(member);
//    }

    @Test
    public void boardTest(){
        addBoard();
        replyTest();
        getBoardList();
        getBoardReplyList();
    }

    @Test
    public void getBoardList(){
        boardRepository.findAll().stream().forEach(System.out::println);
    }

    @Test
    public void getBoardReplyList(){
        boardRepository.findById(1L).orElseThrow().getReplyList().stream().forEach(System.out::println);
    }

    @Test
    public void addBoard(){
        Board board = new Board();
        board.setSubject("첫번째 글");
        board.setContent("첫번째 글의 내용입니다.");
        board.setWriter(memberRepository.findByLoginId("ch624"));
        boardRepository.save(board);
    }

    @Test
    public void replyTest(){
        Board board = boardRepository.findById(1L).orElseThrow();

        Reply reply1 = new Reply();
        reply1.setContent("첫번째 댓글입니다.");
        reply1.setWriter(memberRepository.findByLoginId("ch624"));
        reply1.setBoard(board);
        replyRepository.save(reply1);

        Reply reply2 = new Reply();
        reply2.setContent("두번째 댓글입니다.");
        reply2.setWriter(memberRepository.findByLoginId("ch624"));
        reply2.setBoard(board);
        replyRepository.save(reply2);
    }
}