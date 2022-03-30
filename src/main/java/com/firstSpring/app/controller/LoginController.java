package com.firstSpring.app.controller;

import com.firstSpring.app.domain.UserDto;
import com.firstSpring.app.service.UserService;
import com.firstSpring.app.valid.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("login")
public class LoginController {
    @InitBinder
    public void validUser(WebDataBinder binder) {
        binder.setValidator(new UserValidator()); // UserValidator를 WebDataBinder의 Local Validator로 들옥
    }

    @Autowired
    private UserService userService;

    @GetMapping("/error")
    public String error() throws Exception {
        throw new Exception();
    }

    @GetMapping("/logout")
    public String logout(HttpSession session, RedirectAttributes rattr) throws Exception {
        session.invalidate();
        rattr.addFlashAttribute("msg", "LOGOUT");
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid UserDto userDto, boolean rememberId, HttpSession session, HttpServletResponse response, Model m, BindingResult result) {
        try {
            UserDto dbUserDto = userService.login(userDto);
            if((dbUserDto == null) || result.hasErrors()) {
                m.addAttribute("msg", "LOG_ERR");
                m.addAttribute("email", userDto.getEmail());
                return "login";
            }

            session.setAttribute("email", dbUserDto.getEmail());
            session.setAttribute("name", dbUserDto.getName());
            System.out.println("session.getAttribute(\"name\") = " + session.getAttribute("name"));
            Cookie cookie = new Cookie("email", dbUserDto.getEmail());
            if(!rememberId) {
                cookie.setMaxAge(0);
            }
            response.addCookie(cookie);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }


    @PostMapping("/signIn")
    public String SignIn(@Valid UserDto userDto, HttpSession session, Model m, BindingResult result) throws Exception {
        // 수동검증 ( Validate를 수동으로 생성, 검증하는 것
//        UserValidator userValidator = new UserValidator();
//        userValidator.validate(userDto, result);

        System.out.println("result = " + result);
        // Error 발생시 다시 회원가입 화면 보여주기
        if (result.hasErrors()) {
            return "error";
        }

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
