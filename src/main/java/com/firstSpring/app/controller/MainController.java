package com.firstSpring.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @RequestMapping("/goLogin")
    public String goLogin() {
        return "login";
    }
}
