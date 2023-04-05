package com.etjava.test;

import org.apache.ibatis.session.SqlSession;

import com.etjava.mappers.StudentMapper;
import com.etjava.model.Student;
import com.etjava.util.SqlSessionFactoryUtil;
import org.apache.log4j.Logger;

public class StudentTest {

	private static Logger logger = Logger.getLogger(StudentTest.class);

	public static void main(String[] args) {
		// 获取SqlSession
		SqlSession sqlSession = SqlSessionFactoryUtil.openSession();
		// 获取Mapper mybatis帮我们做的映射接口
		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
		// 添加数据到数据库
		Student stu = new Student("Jerry",21);
		int res = studentMapper.add(stu);
		// 执行完成需要手动提交事务
		sqlSession.commit();
		logger.info("添加成功");
		System.out.println(res);
	}
}
