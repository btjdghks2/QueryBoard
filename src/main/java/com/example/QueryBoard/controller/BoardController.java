package com.example.QueryBoard.controller;


import com.example.QueryBoard.domain.Board;
import com.example.QueryBoard.dto.CommentResponseDto;
import com.example.QueryBoard.dto.FindByBoardRequestDto;
import com.example.QueryBoard.dto.SearchTitle;
import com.example.QueryBoard.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {
    // 여기서 한다면 모델 어트리뷰트로 쏴주는 부분

    private final BoardService boardService;

//    @GetMapping("/")
//    public String home(Model model) {
//        model.addAttribute("board",boardService.mainList());
//        return "main";
//    }

    @GetMapping("/login")
    String login() {
        return "login";
    }

    @GetMapping("/login/join")
    public String memberJoin() {
        return "join";
    }

    @GetMapping("/")
    public String Pagingcon(Model model, @PageableDefault(size =20,sort = "id",direction = Sort.Direction.DESC) Pageable pageable) {

        Page<Board> list = boardService.Pagingser(pageable);

        model.addAttribute("board",boardService.Pagingser(pageable));
        model.addAttribute("previous", pageable.previousOrFirst().getPageNumber());
        model.addAttribute("next", pageable.next().getPageNumber());
        model.addAttribute("hasNext", list.hasNext());
        model.addAttribute("hasPrev", list.hasPrevious());



        return "main";
    }

    @GetMapping("/best")
    public String bestHome(Model model) {
        model.addAttribute("board",boardService.bestList());

        return "bestList";
    }

    @GetMapping("/detail/{id}")
    public String deteailBoard(@PathVariable Long id, Model model) {

        FindByBoardRequestDto dto = boardService.findByBoardDetail(id);
        List<CommentResponseDto> comments = dto.getCommentList();


        if (comments != null && !comments.isEmpty()) {
            model.addAttribute("comments", comments);
        }
        model.addAttribute("board",boardService.findByBoardDetail(id));

        return "detailPage";
    }

    @GetMapping("/new")
    public String newBoard() {
        return "createPage";
    }

    @GetMapping("/detail/edit/{id}")
    public String editBoard(@PathVariable Long id,Model model) {
        FindByBoardRequestDto dto = boardService.findByBoardDetail(id);
        model.addAttribute("board",dto);
        return "editPage";
    }

    @GetMapping("/search")
    public String searchControl(String keyword,Model model) {
        List<SearchTitle> searchList = boardService.search(keyword);
        model.addAttribute("searchList",searchList);

        return "searchPage";
    }
}
