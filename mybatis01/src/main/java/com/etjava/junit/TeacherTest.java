package com.etjava.junit;

import com.etjava.mappers.StudentMapper;
import com.etjava.mappers.TeacherMapper;
import com.etjava.model.Teacher;
import com.etjava.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.*;

public class TeacherTest {
    private static Logger logger = Logger.getLogger(TeacherTest.class);
    // 定义SQLSession 用来操作数据库
    SqlSession sqlSession = null;
    // 获取Student映射文件
    TeacherMapper teacherMapper = null;
    // 测试方法执行之前
    @Before
    public void setUp(){
        sqlSession = SqlSessionFactoryUtil.openSession();
        teacherMapper = sqlSession.getMapper(TeacherMapper.class);
    }

    // 测试方法执行之后
    @After
    public void tearDown(){
        sqlSession.close();
    }

    // 测试多条件查询 if判断
    @Test
    public void testFind(){
        Map<String,Object> map = new HashMap<>();
        //map.put("teaName","Tom");
        List<Teacher> list = teacherMapper.find(map);
        for (Teacher teacher : list) {
            System.out.println(teacher);
        }
    }

    @Test
    public void testFind2(){
        Map<String,Object> map = new HashMap<>();
        map.put("searchBy","name");
        map.put("teaName","Tom");
        List<Teacher> list = teacherMapper.find2(map);
        for (Teacher teacher : list) {
            System.out.println(teacher);
        }
    }
    @Test
    public void testFind3(){
        Map<String,Object> map = new HashMap<>();
        map.put("teaName","Tom");
        List<Teacher> list = teacherMapper.find3(map);
        for (Teacher teacher : list) {
            System.out.println(teacher);
        }
    }

    @Test
    public void testFind4(){
        Map<String,Object> map = new HashMap<>();
        map.put("teaName","Tom");
        List<Teacher> list = teacherMapper.find4(map);
        for (Teacher teacher : list) {
            System.out.println(teacher);
        }
    }

    @Test
    public void testFind5(){
        Map<String,Object> map = new HashMap<>();
        map.put("teaName","Tom");
        List<Integer> ids = new ArrayList<>();
        Collections.addAll(ids,1,2);
        map.put("ids",ids);
        List<Teacher> list = teacherMapper.find5(map);
        for (Teacher teacher : list) {
            System.out.println(teacher);
        }
    }

    @Test
    public void testUpdate(){
       Teacher teacher = new Teacher();
       teacher.setId(1);
       teacher.setTeaAge(22);
       teacher.setTeaName("Tom2");
       teacherMapper.update(teacher);
       sqlSession.commit();// 更新操作 junti测试时需要手动提交
    }

    @Test
    public void testAdd(){
        Teacher teacher = new Teacher();
        teacher.setId(1);
        teacher.setTeaAge(22);
        teacher.setTeaName("Tom2");
        teacher.setRemark("这是一个很长的文本内容...........");
        byte[] pic = null;
        try (FileInputStream fis = new FileInputStream("C:\\Users\\etjav\\Pictures\\Saved Pictures\\2e909e1cc83ff32554a2430dca949b61.jpg");){
            pic = new byte[fis.available()];// available 文件的长度
            fis.read(pic);// 将文件存放到字节数组中
        }catch (Exception e){
            e.printStackTrace();
        }
        teacher.setPic(pic);
        int res = teacherMapper.addTeacher(teacher);
        System.out.println(res);
        sqlSession.commit();
    }

    @Test
    public void testFindById(){
        Teacher tea = teacherMapper.findById(6);
        System.out.println(tea);// 普通属性直接输出
        // 图片数据需要保存到本地磁盘
        byte[] pic = tea.getPic();
        try(FileOutputStream fos = new FileOutputStream("d:/1.jpg")){
            fos.write(pic);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test(){
        Teacher tom = teacherMapper.findA3("Tom", 12);
        System.out.println(tom);
    }
    @Test
    public void test2(){
        // RowBounds 构造方法有两个参数
        // 第一个相当于start  起始页
        // 第二个相当于截止页码
        // 相当于 limit 0,3  注意 这是在内存中进行分页的
        List<Teacher> list = teacherMapper.findA4(new RowBounds(3, 3));
        for (Teacher teacher : list) {
            System.out.println(teacher);
        }
    }

    @Test
    public void test3(){
        Map<String,Object> map = new HashMap<>();
        map.put("start",0);
        map.put("size",2);
        List<Teacher> list = teacherMapper.findA5(map);
        for (Teacher teacher : list) {
            System.out.println(teacher);
        }
    }

}
