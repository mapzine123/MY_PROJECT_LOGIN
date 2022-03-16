package com.firstSpring.app.service;

import com.firstSpring.app.dao.UserDao;
import com.firstSpring.app.domain.UserDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public int register(UserDto userDto) throws Exception {
        int rowCnt = userDao.insert(userDto);
        return rowCnt;
    }

    public UserDto login(UserDto userDto) throws Exception {
        UserDto result = userDao.select(userDto);
        return result;
    }
}
