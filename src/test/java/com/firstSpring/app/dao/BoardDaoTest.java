package com.firstSpring.app.dao;

import com.firstSpring.app.domain.BoardDto;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/root-context.xml")
public class BoardDaoTest {

    @Autowired
    private BoardDao dao;
    @Test
    public void insert() throws Exception {
        int cnt = 0;
        for(int i = 0; i < 255; i++) {
            BoardDto dto = new BoardDto(i + "번째name", i + "번째 title", i + "번째 content");
            dao.insert(dto);
            cnt++;
        }
        assertTrue(cnt == 255);
    }
}