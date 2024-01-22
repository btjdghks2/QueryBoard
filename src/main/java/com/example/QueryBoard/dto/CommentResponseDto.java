package com.example.QueryBoard.dto;

import com.example.QueryBoard.domain.Comment;
import lombok.Data;

@Data
public class CommentResponseDto {
    private Long id;
    private String commentcontent;
    private Long boardId;

    public CommentResponseDto(Comment comment) {
        this.id = comment.getId();
        this.commentcontent = comment.getCommentcontent();
        this.boardId = comment.getBoard().getId();
    }
}
