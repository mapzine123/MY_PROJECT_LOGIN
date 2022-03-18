package com.firstSpring.app.service;

import com.firstSpring.app.dao.UserDao;
import com.firstSpring.app.domain.UserDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public int register(UserDto userDto) throws Exception {
        int rowCnt1 = userDao.insert(userDto);
        return userDao.insert(userDto);
    }
    @Transactional(rollbackFor = Exception.class)
    public int register1(UserDto userDto) throws Exception {
        int rowCnt1 = userDao.insert(userDto);
        int rowCnt2 = userDao.insert(userDto);
        return rowCnt2;
    }

    public UserDto login(UserDto userDto) throws Exception {
        UserDto result = userDao.select(userDto);
        return result;
    }
}
