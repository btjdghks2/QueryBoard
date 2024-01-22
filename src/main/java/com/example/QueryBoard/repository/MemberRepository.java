package com.example.QueryBoard.repository;

import com.example.QueryBoard.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Long> {
    Optional<Object> findByEmail(String username);
}
