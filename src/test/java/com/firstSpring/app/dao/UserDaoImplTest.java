package com.firstSpring.app.dao;

import com.firstSpring.app.domain.UserDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/root-context.xml")
public class UserDaoImplTest {

    @Autowired
    private UserDao userDao;

    @Autowired
    private DataSource ds;

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

    @Test
    public void insertTran() throws Exception {
        PlatformTransactionManager tm = new DataSourceTransactionManager(ds);
        TransactionStatus status = tm.getTransaction(new DefaultTransactionDefinition());
        try {
            UserDto dto = new UserDto("asdf112323@naver.com", "as", "asd");
            userDao.insert(dto);
            userDao.insert(dto);
            tm.commit(status);

        } catch(Exception e) {
            e.printStackTrace();
            tm.rollback(status);
        } finally {

        }


    }

    @Test
    public void select() throws Exception {
        UserDto dto = new UserDto("asdf", "1234");
        UserDto result = userDao.select(dto);
        System.out.println("result = " + result);
        assertTrue(result != null);

    }
}