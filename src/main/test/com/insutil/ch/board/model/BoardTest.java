package com.insutil.ch.board.model;

import com.insutil.ch.board.repository.BoardRepository;
import com.insutil.ch.board.repository.ReplyRepository;
import com.insutil.ch.member.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BoardTest {

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    BoardRepository boardRepository;
    @Autowired
    ReplyRepository replyRepository;

    @Test
    public void boardTest(){
        Board board = new Board();
        board.setSubject("첫번째 게시글");
        board.setContent("첫번째 게시글 내용입니다..");
        board.setWriter(memberRepository.findByLoginId("ch624"));
        boardRepository.save(board);
        boardRepository.findAll().stream().forEach(System.out::println);
    }
}