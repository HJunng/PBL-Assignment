package pblassignment.board.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pblassignment.board.dto.BoardDTO;
import pblassignment.board.service.BoardService;

@Controller
@RequestMapping("/board") // "/board"로 매핑 된 것들을 가져옴.
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/save")
    public String saveForm(){
        return "save";
    }

    @PostMapping("/save") // 폼 데이터 전체를 dto 모델로 받아와서 저장하면 쉬워짐.!!
    public String save(@ModelAttribute BoardDTO boardDTO){
        System.out.println("boardDTO = " + boardDTO);
        boardService.save(boardDTO);

        return "index";
    }
}
