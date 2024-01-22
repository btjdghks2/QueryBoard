package com.example.QueryBoard.dto;

import com.example.QueryBoard.domain.Board;
import lombok.Data;

@Data
public class FindAllBoardList {

    private Long id;

    private String title;

    private String content;

    private int view;

    private String createdAt;



    public FindAllBoardList(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.view = board.getView();
        this.createdAt = String.valueOf(board.getCreatedAt());

    }
}
