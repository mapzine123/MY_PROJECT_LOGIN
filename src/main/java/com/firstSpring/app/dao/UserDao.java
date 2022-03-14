package com.firstSpring.app.dao;

import com.firstSpring.app.domain.UserDto;
import org.springframework.stereotype.Component;

@Component
public interface UserDao {
    int insert(UserDto dto)throws Exception;
}
