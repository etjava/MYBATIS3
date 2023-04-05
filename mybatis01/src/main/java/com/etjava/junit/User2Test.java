package com.etjava.junit;

import com.etjava.mappers.TeacherMapper;
import com.etjava.mappers.User2Mapper;
import com.etjava.model.Dept;
import com.etjava.model.Teacher;
import com.etjava.model.User2;
import com.etjava.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class User2Test {
    private static Logger logger = Logger.getLogger(User2Test.class);
    // 定义SQLSession 用来操作数据库
    SqlSession sqlSession = null;
    // 获取Student映射文件
    User2Mapper userMapper = null;
    // 测试方法执行之前
    @Before
    public void setUp(){
        sqlSession = SqlSessionFactoryUtil.openSession();
        userMapper = sqlSession.getMapper(User2Mapper.class);
    }

    // 测试方法执行之后
    @After
    public void tearDown(){
        sqlSession.close();
    }

    @Test
    public void testInsert(){
        User2 u = new User2();
        u.setName("Judy");
        u.setAge(16);
        Integer res = userMapper.add(u);
        System.out.println(res);
        sqlSession.commit();
    }

    @Test
    public void testUpdate(){
        User2 u = new User2();
        u.setName("Judy2");
        u.setAge(16);
        u.setId(6);
        Integer res = userMapper.update(u);
        System.out.println(res);
        sqlSession.commit();
    }

    @Test
    public void testDelete(){
        Integer res = userMapper.delete(3);
        System.out.println(res);
        sqlSession.commit();
    }

    @Test
    public void testQuery(){
        User2 user = userMapper.findById(1);
        System.out.println(user);
    }
    @Test
    public void testQuery2(){
        List<User2> list = userMapper.list();
        for (User2 user2 : list) {
            System.out.println(user2);
        }
    }

    @Test
    public void testQuery3(){
        List<User2> u = userMapper.findUserWithAddress();
        for (User2 user2 : u) {
            System.out.println(user2);
        }
    }
    @Test
    public void findUserWithDept(){
        List<User2> u = userMapper.findUserWithDept(1);
        for (User2 user2 : u) {
            System.out.println(user2);
            Dept dept = user2.getDept();
            System.out.println(dept);
        }
    }




}
