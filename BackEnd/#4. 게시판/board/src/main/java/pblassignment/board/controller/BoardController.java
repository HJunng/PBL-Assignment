package pblassignment.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board") // "/board"로 매핑 된 것들을 가져옴.
public class BoardController {

    @GetMapping("/save")
    public String saveForm(){
        return "save";
    }
}
