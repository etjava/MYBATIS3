package com.etjava.mappers;

import com.etjava.model.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface DeptMapper {

    @Select("select * from t_dept where id=#{id}")
    @Results(
            {
                    @Result(id = true,column = "id",property = "id"),
                    @Result(column = "deptName",property = "deptName"),
                    // 关联查询 需要带入当前表的主键 到User表中根据外键查询
                    @Result(column = "id",property = "userList"
                    ,many = @Many(select = "com.etjava.mappers.User2Mapper.findUserWithDeptId"))
            }
    )
    Dept findById(Integer id);


    // type 指定SQL提供者
    // method 指定SQL提供者中的具体某个方法
    @InsertProvider(type = DeptSQLProvider.class,method = "insertDept")
    Integer add(Dept dept);

    @UpdateProvider(type=DeptSQLProvider.class,method = "updateDept")
    Integer update(Dept d);
    @DeleteProvider(type=DeptSQLProvider.class,method = "deleteDept")
    Integer delete(Integer id);

    @SelectProvider(type=DeptSQLProvider.class,method = "selectById")
    Dept findById2(Integer id);

    @SelectProvider(type=DeptSQLProvider.class,method = "findAll")
    List<Dept> findAll(Map<String,Object> map);








}
