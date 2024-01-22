package com.example.QueryBoard.repository;

import com.example.QueryBoard.domain.Board;
import com.example.QueryBoard.dto.CommentCountDto;
import com.example.QueryBoard.dto.FindAllBestList;

import java.util.List;

public interface BoardCustom {

    List<FindAllBestList> findByViewGreaterThan(int viewCount);



}
