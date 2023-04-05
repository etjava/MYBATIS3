package com.etjava.junit;

import com.etjava.mappers.GradeMapper;
import com.etjava.mappers.StudentMapper;
import com.etjava.model.Grade;
import com.etjava.model.Student;
import com.etjava.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

// 测试SQL映射器
public class TestGradeSQLMapping {
    private static Logger logger = Logger.getLogger(TestGradeSQLMapping.class);
    // 定义SQLSession 用来操作数据库
    SqlSession sqlSession = null;
    // 获取Student映射文件
    GradeMapper gradeMapper = null;
    // 测试方法执行之前
    @Before
    public void setUp(){
        sqlSession = SqlSessionFactoryUtil.openSession();
        gradeMapper = sqlSession.getMapper(GradeMapper.class);
    }

    // 测试方法执行之后
    @After
    public void tearDown(){
        sqlSession.close();
    }


    @Test
    public void testFindByGradeId(){
        Grade grade = gradeMapper.findById(1);
        System.out.println(grade);
    }

    @Test
    public void test(){
        List<Grade> gradeList = gradeMapper.findAll();
        for (Grade grade : gradeList) {
            System.out.println(grade);
        }
    }
}
