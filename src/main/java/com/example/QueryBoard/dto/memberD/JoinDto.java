package com.example.QueryBoard.dto.memberD;

import com.example.QueryBoard.domain.Member;

public record JoinDto(String name, String email, String password) {

    public Member toEntity() {
        return Member.builder()
                .name(name)
                .email(email)
                .password(password)
                .build();
    }
}
