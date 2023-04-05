package com.etjava.junit;

import com.etjava.mappers.GradeMapper;
import com.etjava.mappers.RoleMapper;
import com.etjava.mappers.UserMapper;
import com.etjava.model.Grade;
import com.etjava.model.Role;
import com.etjava.model.User;
import com.etjava.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

// 测试SQL映射器
public class Many2ManyTest {
    private static Logger logger = Logger.getLogger(Many2ManyTest.class);
    // 定义SQLSession 用来操作数据库
    SqlSession sqlSession = null;
    // 获取Student映射文件
    UserMapper userMapper = null;
    RoleMapper roleMapper = null;
    // 测试方法执行之前
    @Before
    public void setUp(){
        sqlSession = SqlSessionFactoryUtil.openSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
        roleMapper = sqlSession.getMapper(RoleMapper.class);
    }

    // 测试方法执行之后
    @After
    public void tearDown(){
        sqlSession.close();
    }


    @Test
    public void testUser(){
        List<User> users = userMapper.findAll();
        for(User user : users){
            System.out.println("-----每个用户的信息------");
            System.out.println(user);
            System.out.println(user.getRoles());
        }
    }

    @Test
    public void testRole(){
        List<Role> roles = roleMapper.findAll();
        for(Role user : roles){
            System.out.println("-----每个角色的信息------");
            System.out.println(user);
            System.out.println(user.getUsers());
        }
    }
}
