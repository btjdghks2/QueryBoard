package com.example.QueryBoard.dto;

import com.example.QueryBoard.domain.Board;
import lombok.Builder;
import lombok.Data;

@Data
public class CreateBoardDto {

    private String title;
    private String content;


    @Builder
    public Board toEntity() {
        return Board.builder()
                .title(title)
                .content(content)
                .build();
    }

}
