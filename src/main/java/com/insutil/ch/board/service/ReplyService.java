package com.insutil.ch.board.service;

import com.insutil.ch.board.model.Board;
import com.insutil.ch.board.model.Reply;
import com.insutil.ch.board.repository.BoardRepository;
import com.insutil.ch.board.repository.ReplyRepository;
import com.insutil.ch.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ReplyService {
    private final ReplyRepository replyRepository;
    private final MemberRepository memberRepository;
    private final BoardRepository boardRepository;

    public void replyTest(){
        Reply reply = replyRepository.findById(1L).orElseThrow();
        Board board = boardRepository.findById(2L).orElseThrow();
        board.getReplyList().add(reply);
    }
}
