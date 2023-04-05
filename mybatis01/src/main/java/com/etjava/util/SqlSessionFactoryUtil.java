package com.etjava.util;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 获取数据库连接 操作数据库工具类
 *
 */
public class SqlSessionFactoryUtil {

	private static SqlSessionFactory sqlSessionFactory;
	// 创建SqlSessionFactory
	private static SqlSessionFactory getSqlSessionFactory() {
		if(sqlSessionFactory==null) {
			InputStream is = null;
			try {
				is = Resources.getResourceAsStream("mybatis-config.xml");
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sqlSessionFactory;
	}
	// 打开连接
	public static SqlSession openSession() {
		return getSqlSessionFactory().openSession();
	}

	public static void main(String[] args) {
		openSession();
	}
}
