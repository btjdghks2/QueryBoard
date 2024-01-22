package com.example.QueryBoard.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;
import java.util.UUID;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId; //식별넘버

    private String name;

    @Column(unique = true)
    private String email; //username: 로그인 할때 아이디

    private String password;


}