package com.example.QueryBoard.repository;

import com.example.QueryBoard.domain.QBoard;
import com.example.QueryBoard.domain.QComment;
import com.example.QueryBoard.dto.CommentCountDto;
import com.example.QueryBoard.dto.FindAllBestList;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class BoardCustomImpl implements BoardCustom{

    private final JPAQueryFactory queryFactory;


    @Override
    public List<FindAllBestList> findByViewGreaterThan(int viewCount) {
        // "SELECT * FROM BOARD B WHERE B.view >10"

        QBoard board = QBoard.board;

        JPAQuery<Tuple> query = queryFactory
                .select(board.id,board.title,board.content,board.view,board.createdAt)
                .from(board)
                .where(board.view.gt(10));

        return query.fetch().stream().map(tupple -> FindAllBestList.builder()
                .id(tupple.get(board.id))
                .title(tupple.get(board.title))
                .content(tupple.get(board.content))
                .view(tupple.get(board.view))
                .createdAt(tupple.get(board.createdAt))
                .build()).toList();
    }





}
