package com.etjava.junit;

import com.etjava.mappers.StudentMapper;
import com.etjava.model.Student;
import com.etjava.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

// 测试SQL映射器
public class TestSQLMapping {
    private static Logger logger = Logger.getLogger(TestSQLMapping.class);
    // 定义SQLSession 用来操作数据库
    SqlSession sqlSession = null;
    // 获取Student映射文件
    StudentMapper studentMapper = null;
    // 测试方法执行之前
    @Before
    public void setUp(){
        sqlSession = SqlSessionFactoryUtil.openSession();
        studentMapper = sqlSession.getMapper(StudentMapper.class);
    }

    // 测试方法执行之后
    @After
    public void tearDown(){
        sqlSession.close();
    }

    // 添加学生
    @Test
    public void teseAdd(){
        int res = studentMapper.add(new Student("Jerry", 13));
        System.out.println(res>0?"添加成功":"添加失败");
    }

    // 修改学生信息
    @Test
    public void teseUpdate(){
        int res = studentMapper.update(new Student(1, "Andy", 12));
        System.out.println(res>0?"修改成功":"修改失败");
    }

    // 删除学生信息
    @Test
    public void testDelete(){
        int res = studentMapper.delete(2);
        System.out.println(res>0?"删除成功":"删除失败");
    }

    // 根据ID查询学生信息
    @Test
    public void testFindById(){
        Student stu = studentMapper.findById(1);
        System.out.println(stu);
    }

    // 根据姓名模糊匹配学生信息
    @Test
    public void testFindByName(){
        List<Student> stuList = studentMapper.findByName("T");
        System.out.println(stuList.size());
    }

    // 查询全部学生信息 带分页
    @Test
    public void testFindAll(){
        List<Student> stuList = studentMapper.findAll();
        System.out.println(stuList.size());
    }

    @Test
    public void testFindStudentWithAddress(){
        Student stu = studentMapper.findStudentWithAddress(8);
        System.out.println(stu.getStuName()+"==="+stu.getAddress().getSheng());
    }

    // 查询学生信息带年级 一对一
    @Test
    public void testStudentWithGrade(){
        Student stu = studentMapper.findByIdWithGrade(2);
        System.out.println(stu.getStuName()+"==="+stu.getAddress().getSheng()+"=="+stu.getGrade().getGradeName());
    }

}
