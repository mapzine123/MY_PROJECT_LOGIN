package com.firstSpring.app.service;

import com.firstSpring.app.dao.BoardDao;
import com.firstSpring.app.domain.BoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BoardService {
    @Autowired
    private BoardDao boardDao;

    public int write(BoardDto boardDto) throws Exception {
        return boardDao.insert(boardDto);
    }

    public List<BoardDto> getPage(Map map) throws Exception {
        return boardDao.getPage(map);
    }

    public int getCount() throws Exception {
        return boardDao.count();
    }

    public BoardDto read(int bno) throws Exception {
        return boardDao.select(bno);
    }
}
