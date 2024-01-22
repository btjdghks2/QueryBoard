package com.example.QueryBoard.dto;


import com.example.QueryBoard.domain.Board;
import com.example.QueryBoard.domain.Comment;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class CommentRequestDto {

    private Long id;
    private String commentcontent;
    private String createdDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"));
    private String modifiedDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"));
    private Board board;



    public Comment toEntity() {
        Comment comment = Comment.builder()
                .id(id)
                .commentcontent(commentcontent)
                .board(board)
                .build();
        return comment;

    }
}
