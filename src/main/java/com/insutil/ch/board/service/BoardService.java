package com.insutil.ch.board.service;

import com.insutil.ch.board.model.Board;
import com.insutil.ch.board.repository.BoardRepository;
import com.insutil.ch.common.response.OperationAndMakeResponse;
import com.insutil.ch.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class BoardService implements OperationAndMakeResponse {
    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    public List<Board> getBoardList() {
        return boardRepository.findAll();
    }
    public Board getBoard(Long id) {
        return boardRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    public boolean inserBoard(Board board) {
        board.setWriter(memberRepository.findByLoginId(SecurityContextHolder.getContext().getAuthentication().getName()));
        board.setWriteDate(new Date());
        boardRepository.save(board);
        return true;
    }
}
