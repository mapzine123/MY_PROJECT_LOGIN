package com.firstSpring.app.controller;

import com.firstSpring.app.domain.BoardDto;
import com.firstSpring.app.domain.PageHandler;
import com.firstSpring.app.domain.SearchCondition;
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

    @PostMapping("/delete")
    public String delete(Integer bno, Model m, HttpSession session, RedirectAttributes rattr) {
        try {
            Map map = new HashMap();
            map.put("bno", bno);
            map.put("email", (String)session.getAttribute("email"));
            int rowCnt = boardService.delete(map);
            if (rowCnt != 1) {
                throw new Exception("delete ERR");
            }
            rattr.addFlashAttribute("msg", "DEL_OK");
            return "redirect:/board/boardList";
        } catch (Exception e) {
            e.printStackTrace();
            rattr.addFlashAttribute("msg", "DEL_ERR");
            return "viewBoard";
        }
    }

    @PostMapping("/goModify")
    public String goModify(BoardDto boardDto, Model m) {
        System.out.println("boardDto in gomodify = " + boardDto);
        m.addAttribute(boardDto);
        m.addAttribute("mode", "modify");
        return "writeBoard";
    }

    @PostMapping("/modify")
    public String modify(BoardDto boardDto, Model m, HttpSession session, RedirectAttributes rattr) {
        try {
            boardDto.setName((String)session.getAttribute("name"));
            boardDto.setEmail((String)session.getAttribute("email"));
            int rowCnt = boardService.modify(boardDto);
            if(rowCnt != 1) {
                throw new Exception("Modify_error");
            }
            rattr.addFlashAttribute("msg", "MOD_OK");
            return "redirect:/board/boardList";
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

            if(boardDto.getEmail().equals(session.getAttribute("email"))) {
                m.addAttribute("mode", "accessable");
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
    public String boardList(SearchCondition sc, String option, HttpServletRequest request, HttpSession session, Model m) {
        if(session.getAttribute("email") == null) {
            return "login";
        }

        try {
            int totalCnt = boardService.getCount();
            PageHandler pageHandler = new PageHandler(totalCnt, sc);

            List<BoardDto> list = boardService.getSearchResultPage(sc);
            m.addAttribute("totalCnt", totalCnt);
            m.addAttribute("list", list);
            m.addAttribute("ph", pageHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "boardList";
    }

    @GetMapping("/write")
    public String write(Model m) {
        m.addAttribute("mode", "new");
        return "writeBoard";
    }
    @PostMapping("/write")
    public String write(BoardDto boardDto, HttpSession session, Model m, RedirectAttributes rattr) {
        boardDto.setName((String)session.getAttribute("name"));
        boardDto.setEmail((String)session.getAttribute("email"));
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
            return "redirect:/board/viewBoard";
        }

    }
}
