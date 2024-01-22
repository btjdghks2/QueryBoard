package com.example.QueryBoard.repository;

import com.example.QueryBoard.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long>{
}
