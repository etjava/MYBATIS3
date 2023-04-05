package com.etjava.model;

public class Student {

	private Integer id;
	private String stuName;
	private Integer age;
	private Address address;

	private Grade grade;
	
	public Student() {
		super();
	}

	public Student(Integer id, String stuName, Integer age) {
		this.id = id;
		this.stuName = stuName;
		this.age = age;
	}

	public Student(String stuName, Integer age) {
		super();
		this.stuName = stuName;
		this.age = age;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}

	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Student{" +
				"id=" + id +
				", stuName='" + stuName + '\'' +
				", age=" + age +
				", address=" + address +
				'}';
	}
}
