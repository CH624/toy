package com.insutil.ch.board.controller;

import com.insutil.ch.board.model.Board;
import com.insutil.ch.board.service.BoardService;
import com.insutil.ch.common.response.ContentResponse;
import com.insutil.ch.common.response.OperationResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/api/board/info")
    public ResponseEntity<OperationResponse> getBoardList() {
        log.info("BoardController.getBoardList");
        ContentResponse<List<Board>> response = new ContentResponse<>(OperationResponse.ResponseStatusEnum.SUCCESS, "SUCCESS");
        response.setContent(boardService.getBoardList());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/api/board/{id}")
    public ResponseEntity<OperationResponse> getBoard(@PathVariable Long id) {
        log.info("BoardController.getBoard board_id: " + id);
        ContentResponse<Board> response = new ContentResponse<>(OperationResponse.ResponseStatusEnum.SUCCESS, "SUCCESS");
        response.setContent(boardService.getBoard(id));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/api/board/info")
    public ResponseEntity<OperationResponse> insertBoard(@RequestBody Board board) {
        log.info("BoardController.insertBoard");
        OperationResponse response = boardService.operationAndMakeResponse(boardService.inserBoard(board), "SUCCESS");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
