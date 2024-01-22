package com.example.QueryBoard.repository;

import com.example.QueryBoard.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long>,BoardCustom {

    List<Board> findByTitleContaining(String keyword);
}
