package com.mybatis.test;

import com.mybatis.mapper.SQLMapper;
import com.mybatis.pojo.User;
import com.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class SQLMapperTest {

    @Test
    public void testGetUserByLike(){

        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        List<User> list = mapper.getUserByLike("a");
        System.out.println(list);
    }

    @Test
    public void testGetUserByTableName(){

        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        List<User> list = mapper.getUserByTableName("t_user");
        System.out.println(list);
    }

    @Test
    public void testDeleteMore(){

        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        int result = mapper.deleteMore("1,2,3");
        System.out.println(result);
    }

    @Test
    public void testInsertUser(){

        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        User user = new User(null,"Wang","123",35,"男","123@qq,com");
        mapper.insertUser(user);
        System.out.println(user);
    }

//    @Test
//    public void testJDBC(){
//        Class.forName();
//        Connection connection = DriverManager.getConnection();
//        PreparedStatement ps = connection.prepareStatement("insert", Statement.RETURN_GENERATED_KEYS);
//        ps.executeUpdate();
//        ps.getGeneratedKeys();
//    }
}
