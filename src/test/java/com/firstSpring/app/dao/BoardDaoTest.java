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
            BoardDto dto = new BoardDto(i + "asdff", "asadfasdf");
            cnt++;
            dao.insert(dto);
        }
        assertTrue(cnt == 255);
    }
    @Test
    public void insertBoard() throws Exception {
        BoardDto selectDto = dao.select(79);
        System.out.println("selectDto = " + selectDto);
        assertTrue(selectDto != null);
    }

    @Test
    public void increase() throws Exception {
        int rowCnt = dao.increaseViewCnt(79);
        assertTrue(rowCnt == 1);
    }
}