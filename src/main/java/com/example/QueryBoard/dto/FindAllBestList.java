package com.example.QueryBoard.dto;

import com.example.QueryBoard.domain.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FindAllBestList {

    private Long id;

    private String title;

    private String content;

    private int view;

    private String createdAt;


    public FindAllBestList(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.view = board.getView();
        this.createdAt = String.valueOf(board.getCreatedAt());

    }
}
