package com.example.QueryBoard.dto;

import com.example.QueryBoard.domain.Board;
import lombok.Data;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Getter
public class FindByBoardRequestDto {

    private Long id;
    private String title;
    private String content;

    private List<CommentResponseDto> commentList;

    public FindByBoardRequestDto(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.commentList = board.getComment().stream().map(CommentResponseDto::new).collect(Collectors.toList());
    }
}
