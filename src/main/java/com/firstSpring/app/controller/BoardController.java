package com.firstSpring.app.controller;

import com.firstSpring.app.domain.BoardDto;
import com.firstSpring.app.domain.PageHandler;
import com.firstSpring.app.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @PostMapping("/modify")
    public String modify(BoardDto boardDto, Model m, RedirectAttributes rattr) {
        try {
            int rowCnt = boardService.modify(boardDto);
            if(rowCnt != 1) {
                throw new Exception("Modify_error");
            }
            rattr.addFlashAttribute("msg", "MOD_OK");
            return "redirect:/board/boarList";
        } catch (Exception e) {
            e.printStackTrace();
            rattr.addFlashAttribute("msg", "MOD_ERR");
            m.addAttribute(boardDto);
            return "viewBoard";
        }

    }

    @GetMapping("/read")
    public String board(Integer bno, Integer page, Integer pageSize, Model m, HttpSession session) {

        try {
            BoardDto boardDto = boardService.read(bno);
            System.out.println("boardDto.getEmail() = " + boardDto.getEmail());
            System.out.println("session.getAttribute(\"email\") = " + session.getAttribute("email"));
            
            if(boardDto.getEmail().equals(session.getAttribute("email"))) {
                m.addAttribute("mode", "modify");
            } else {
                m.addAttribute("mode", "read");
            }
            m.addAttribute("page", page);
            m.addAttribute("pageSize", pageSize);
            m.addAttribute("boardDto", boardDto);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "viewBoard";
    }

    @GetMapping("/boardList")
    public String boardList(Integer page, Integer pageSize, HttpServletRequest request, HttpSession session, Model m) {
        if(session.getAttribute("email") == null) {
            return "login";
        }

        if (page == null) {
            page = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }

        try {
            int totalCnt = boardService.getCount();
            PageHandler pageHandler = new PageHandler(totalCnt, page, pageSize);

            Map map = new HashMap();
            map.put("offset", (page - 1) * pageSize);
            map.put("pageSize", pageSize);

            List<BoardDto> list = boardService.getPage(map);
            m.addAttribute("list", list);
            m.addAttribute("ph", pageHandler);
            m.addAttribute("page", page);
            m.addAttribute("pageSize", pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "boardList";
    }

    @GetMapping("/write")
    public String write(Model m) {
        m.addAttribute("mode", "new");
        return "viewBoard";
    }
    @PostMapping("/write")
    public String write(BoardDto boardDto, HttpSession session, Model m, RedirectAttributes rattr) {
        boardDto.setName((String)session.getAttribute("name"));
        boardDto.setEmail((String)session.getAttribute("email"));
        System.out.println("boardDto.getEmail() = " + boardDto.getEmail());
        try {
            int rowCnt = boardService.write(boardDto);
            if (rowCnt != 1) {
                throw new Exception("Write Error");
            }
            rattr.addFlashAttribute("msg", "WRT_OK");
            return "redirect:/board/boardList";
        } catch (Exception e) {
            e.printStackTrace();
            rattr.addFlashAttribute("msg", "WRT_ERR");
            m.addAttribute("title", boardDto.getTitle());
            m.addAttribute("content", boardDto.getContent());
            return "viewBoard";
        }

    }
}
