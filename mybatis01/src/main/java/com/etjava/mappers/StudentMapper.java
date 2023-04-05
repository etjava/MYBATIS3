package com.etjava.mappers;

import com.etjava.model.Student;

import java.util.List;

public interface StudentMapper {

	/**
	 * 添加学生信息
	 * @param stu
	 * @return
	 */
	public int add(Student stu);

	/**
	 * 修改学生信息
	 * @param stu
	 * @return
	 */
	public int update(Student stu);

	/**
	 * 删除学生信息
	 * @param id
	 * @return
	 */
	public int delete(Integer id);

	/**
	 * 根据ID查询学生信息
	 * @param id
	 * @return
	 */
	public Student findById(Integer id);

	// 根据姓名模糊匹配学生信息
	public List<Student> findByName(String name);

	// 带分页的查询
	public List<Student> findAll();

	// 根据学生ID查询学生信息 带地址
	public Student findStudentWithAddress(Integer stuId);

	// 根据年级查询学生信息
	public Student findByGradeId(Integer gradeId);

	// 根据学生ID查询学生信息 带年级
	Student findByIdWithGrade(int id);
}
