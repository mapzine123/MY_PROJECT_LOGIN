package com.firstSpring.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("board")
public class BoardController {

    @GetMapping("/boardList")
    public String boardList() {
        return "boardList";
    }
}
