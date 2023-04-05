package com.etjava.junit;

import com.etjava.mappers.DeptMapper;
import com.etjava.mappers.User2Mapper;
import com.etjava.model.Dept;
import com.etjava.model.User2;
import com.etjava.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeptTest {
    private static Logger logger = Logger.getLogger(DeptTest.class);
    // 定义SQLSession 用来操作数据库
    SqlSession sqlSession = null;
    // 获取Student映射文件
    DeptMapper deptMapper = null;
    // 测试方法执行之前
    @Before
    public void setUp(){
        sqlSession = SqlSessionFactoryUtil.openSession();
        deptMapper = sqlSession.getMapper(DeptMapper.class);
    }

    // 测试方法执行之后
    @After
    public void tearDown(){
        sqlSession.close();
    }


    @Test
    public void testQuery3(){
        Dept d = deptMapper.findById(1);
        System.out.println(d);
    }

    @Test
    public void testInsert(){
        Dept d = new Dept();
        d.setDeptName("教学5部门");
        Integer res = deptMapper.add(d);
        System.out.println(res);
        sqlSession.commit();
    }

    @Test
    public void testUpdate(){
        Dept d = new Dept();
        d.setDeptName("教学5部门2");
        d.setId(4);
        Integer res = deptMapper.update(d);
        System.out.println(res);
        sqlSession.commit();
    }

    @Test
    public void testDelete(){
        Integer res = deptMapper.delete(4);
        System.out.println(res);
        sqlSession.commit();
    }

    @Test
    public void testSelectById(){
        Dept de = deptMapper.findById(1);
        System.out.println(de);
    }

    @Test
    public void testSelectAll(){
        Map<String,Object> map = new HashMap<>();
        map.put("deptName","教学1部");
        List<Dept> all = deptMapper.findAll(map);
        for (Dept dept : all) {
            System.out.println(dept);
        }
    }
}
