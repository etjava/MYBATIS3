package com.etjava.model;

import java.util.List;

public class Grade {
    private Integer id;
    private String gradeName;
    private List<Student> studentList;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public Integer getId() {
        return id;
    }

    public String getGradeName() {
        return gradeName;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", gradeName='" + gradeName + '\'' +
                ", studentList=" + studentList +
                '}';
    }
}
