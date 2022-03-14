package com.firstSpring.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.RequestContext;

@Controller
public class MainController {
    @RequestMapping("/goLogin")
    public String goLogin() {
        return "login";
    }

    @PostMapping("/signIn")
    public String signIn(String id, String email, String pwd, RequestContext request, Model m) {
        return null;
    }
}
