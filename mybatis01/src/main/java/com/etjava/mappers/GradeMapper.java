package com.etjava.mappers;

import com.etjava.model.Grade;

import java.util.List;

public interface GradeMapper {

    // 根据ID查询年级
    Grade findById(Integer id);

    // 查询所有年级信息 带每个年级下的所有学生
    List<Grade> findAll();
}
