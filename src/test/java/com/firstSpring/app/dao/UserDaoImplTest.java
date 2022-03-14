package com.firstSpring.app.dao;

import com.firstSpring.app.domain.UserDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/root-context.xml")
public class UserDaoImplTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void insert() throws Exception {
        int cnt = 0;
        for(int i = 0; i < 100; i++) {
            UserDto dto = new UserDto(i + "@naver.com", "as" + i, "asd" + i);
            userDao.insert(dto);
            cnt++;
        }

        assertTrue(cnt == 100);
    }
}