package com.firstSpring.app.controller;

import com.firstSpring.app.domain.UserDto;
import com.firstSpring.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("login")
public class LoginController {
    @Autowired
    private UserService userService;

    @GetMapping("/logout")
    public String logout(HttpSession session, RedirectAttributes rattr) {
        session.invalidate();
        rattr.addFlashAttribute("msg", "LOGOUT");
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(UserDto userDto, HttpSession session, Model m) {
        try {
            userDto = userService.login(userDto);
            session.setAttribute("email", userDto.getEmail());
            session.setAttribute("name", userDto.getName());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }


    @PostMapping("/signIn")
    public String SignIn(UserDto userDto, HttpSession session, Model m) {
        try {
            int rowCnt = userService.register(userDto);
            if (rowCnt != 1) {
                throw new Exception("register Error");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/login/login";
    }

    @GetMapping("/signIn")
    public String signIn() {
        return "signIn";
    }
}
