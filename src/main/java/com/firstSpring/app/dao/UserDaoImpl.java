package com.firstSpring.app.dao;

import com.firstSpring.app.domain.UserDto;
import com.firstSpring.app.utils.Utils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private SqlSession session;

    @Autowired
    private DataSource ds;

    private Connection con = null;



    private String namespace = "un.mapzine.dao.userMapper.";

    @Override
    public int insert(UserDto dto) throws Exception {
        return session.insert(namespace + "insert", dto);
    }

//    @Override
//    public int insert(UserDto dto) throws Exception {
//        try {
//            con = DataSourceUtils.getConnection(ds);
//            return session.insert(namespace + "insert", dto);
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw e;
//        } finally {
////            Utils.close(con);
//            DataSourceUtils.releaseConnection(con, ds);
//        }
//    }

    @Override
    public UserDto select(UserDto dto) throws Exception {
        return session.selectOne(namespace + "select", dto);
    }
}
