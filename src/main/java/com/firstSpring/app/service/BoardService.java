package com.firstSpring.app.service;

import com.firstSpring.app.dao.BoardDao;
import com.firstSpring.app.domain.BoardDto;
import com.firstSpring.app.domain.SearchCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public List<BoardDto> getSearchResultPage(SearchCondition sc) throws Exception {
        return boardDao.searchSelectPage(sc);
    }
    public int getSearchResultCnt(SearchCondition sc) throws Exception {
        return boardDao.searchResultCnt(sc);
    }


    public int modify(BoardDto boardDto) throws Exception {
        return boardDao.update(boardDto);
    }

    public BoardDto read(int bno) {
        boardDao.increaseViewCnt(bno);

        return boardDao.select(bno);
    }

    public int delete(Map map) {
        return boardDao.delete(map);
    }
}
