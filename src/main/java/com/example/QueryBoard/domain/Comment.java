package com.example.QueryBoard.domain;

import com.example.QueryBoard.domain.time.BaseTime;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Comment extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String commentcontent;

    @Column(columnDefinition = "integer default 0", nullable = false)
    private int ccount;

    @ManyToOne(fetch = FetchType.LAZY)
    private Board board;
}
