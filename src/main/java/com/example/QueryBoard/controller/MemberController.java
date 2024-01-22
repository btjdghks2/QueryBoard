package com.example.QueryBoard.controller;

import com.example.QueryBoard.domain.Member;
import com.example.QueryBoard.dto.memberD.JoinDto;
import com.example.QueryBoard.repository.MemberRepository;
import com.example.QueryBoard.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class MemberController {

    private final BoardService boardService;
    private final MemberRepository memberRepository;

    // 여기서 만들어야 할 것
    // 회원가입 페이지
    // 로그인 페이지


    @PostMapping("/join")
    public Long join(@RequestBody JoinDto joinDto) {
        //멤버 테이블에 저장하는 로직
        // 걍 세이브 기능
        Member member = joinDto.toEntity();
        member = memberRepository.save(member);

        return member.getUserId();
    }




}
