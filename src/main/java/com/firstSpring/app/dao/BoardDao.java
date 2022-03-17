package com.firstSpring.app.dao;

import com.firstSpring.app.domain.BoardDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class BoardDao {
    @Autowired
    private SqlSession session;

    private String namespace = "un.mapzine.dao.boardMapper.";

    public int insert(BoardDto boardDto) throws Exception {
        return session.insert(namespace + "insert", boardDto);
    }

    public List<BoardDto> getPage(Map map) throws Exception {
        return session.selectList(namespace + "selectPage", map);
    }

    public int count() throws Exception {
        return session.selectOne(namespace + "count");
    }

    public BoardDto select(int bno) {
        return session.selectOne(namespace + "select", bno);
    }

    public int increaseViewCnt(int bno) {
        return session.update(namespace + "increaseViewCnt", bno);
    }
}
