package com.firstSpring.app.service;

import com.firstSpring.app.domain.UserDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/root-context.xml")
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void register() throws Exception {
        UserDto dto1 = new UserDto("233@du.com", "as", "asd");
        UserDto dto2 = new UserDto("2123233@gma.com", "as", "asd");

        int rowCnt = userService.register1(dto1);

        System.out.println("return : rowCnt = " + rowCnt);
        assertTrue(rowCnt == 1);
    }

    @Test
    public void login() {
    }
}