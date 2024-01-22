package com.example.QueryBoard.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Data;

@Builder
@Data

public class CommentCountDto {

    private Long id;

    private int count;

    @QueryProjection
    public CommentCountDto(Long id, int count) {
        this.id = id;
        this.count = count;
    }
}
