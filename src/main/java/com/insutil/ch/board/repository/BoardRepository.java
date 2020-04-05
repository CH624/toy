package com.insutil.ch.board.repository;

import com.insutil.ch.board.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
