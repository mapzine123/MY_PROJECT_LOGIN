package com.firstSpring.app.dao;

import com.firstSpring.app.domain.UserDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private SqlSession session;

    private String namespace = "un.mapzine.dao.userMapper.";

    @Override
    public int insert(UserDto dto) throws Exception {
        if (dto == null) {
            System.out.println("null;");
        }
        return session.insert(namespace + "insert", dto);
    }
}
