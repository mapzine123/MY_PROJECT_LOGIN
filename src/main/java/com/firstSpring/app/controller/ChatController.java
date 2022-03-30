package com.firstSpring.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/echo")
public class ChatController {
    @GetMapping("/chat")
    public String goChat(Model m, HttpSession session) {
        if(session.getAttribute("name") == null) {
            return "login";
        }

        m.addAttribute("name", session.getAttribute("name"));
        return "echo";
    }
}
