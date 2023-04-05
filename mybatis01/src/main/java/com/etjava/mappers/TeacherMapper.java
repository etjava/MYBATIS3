package com.etjava.mappers;

import com.etjava.model.Teacher;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

public interface TeacherMapper {

    List<Teacher> find(Map<String,Object> map);

    List<Teacher> find2(Map<String,Object> map);

    List<Teacher> find3(Map<String,Object> map);
    List<Teacher> find4(Map<String,Object> map);
    List<Teacher> find5(Map<String,Object> map);

    void update(Teacher teacher);

    int addTeacher(Teacher teacher);

    Teacher findById(Integer id);

    Teacher findA3(String teaName,int age);

    // 逻辑分页 RowBounds
    List<Teacher> findA4(RowBounds rowBounds);
    // 物理分页
    List<Teacher> findA5(Map<String,Object> map);


}
