package com.example.QueryBoard.controller;

import com.example.QueryBoard.domain.Board;
import com.example.QueryBoard.dto.CommentRequestDto;
import com.example.QueryBoard.dto.CreateBoardDto;
import com.example.QueryBoard.dto.UpdateBoardRequestDto;
import com.example.QueryBoard.repository.BoardRepository;
import com.example.QueryBoard.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BoardApiController {

    private final BoardService boardService;
    private final BoardRepository boardRepository;

    @PostMapping("/api/new")
    public Long createBoard(@RequestBody CreateBoardDto createBoardDto) {
        Board board = createBoardDto.toEntity();
        board = boardRepository.save(board);
        return board.getId();
    }

    @DeleteMapping("/api/detail/delete/{id}")
    public Long deleteBoard(@PathVariable Long id) {

        Board board = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글입니다"));

        boardRepository.delete(board);

        return null;
    }

    @PutMapping("/api/detail/{id}/edit")
    public Long  editBoard(@PathVariable Long id, @RequestBody UpdateBoardRequestDto updateBoardRequestDto) {


        return boardService.editBoardService(id,updateBoardRequestDto);
    }

    @PostMapping("/api/detail/{id}/comments")
    public ResponseEntity commentSave(@PathVariable Long id, @RequestBody CommentRequestDto commentRequestDto) {
        return ResponseEntity.ok(boardService.commentSave(id, commentRequestDto));
    }
}
