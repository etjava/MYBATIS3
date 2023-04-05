package com.etjava.mappers;

import com.etjava.model.User2;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface User2Mapper {


    @Insert("insert into t_user2 values(null,#{name},#{age})")
    Integer add(User2 user2);
    @Update("update t_user2 set name=#{name},age=#{age} where id=#{id}")
    Integer update(User2 user2);
    @Delete("delete from t_user2 where id=#{id}")
    Integer delete(Integer id);

    @Select("select * from t_user2")
    @Results(// 映射结果集 相当于配置文件中的resultMap
            {
                    @Result(id = true,column = "id",property = "id"),
                    @Result(column = "name",property = "name"),
                    @Result(column = "age",property = "age")
            }
    )
    List<User2> list();

    @Select("select * from t_user2 where id=#{id}")
    User2 findById(Integer id);


    @Select("select * from t_user2")
    @Results(// 映射结果集 相当于配置文件中的resultMap
            {
                    @Result(id = true,column = "id",property = "id"),
                    @Result(column = "name",property = "name"),
                    @Result(column = "age",property = "age"),
                    // one = @One 表示一对一 需要关联其他Mapper接口中的查询方法
                    @Result(column = "addressId",property = "address"
                    ,one = @One(select = "com.etjava.mappers.AddressMapper.findById"))
            }
    )
    List<User2> findUserWithAddress();

    @Select("select * from t_user2 where deptId=#{deptId}")
    @Results(// 映射结果集 相当于配置文件中的resultMap
            {
                    @Result(id = true,column = "id",property = "id"),
                    @Result(column = "name",property = "name"),
                    @Result(column = "age",property = "age"),
                    // one = @One 表示一对一 需要关联其他Mapper接口中的查询方法
                    @Result(column = "addressId",property = "address"
                            ,one = @One(select = "com.etjava.mappers.AddressMapper.findById"))
            }
    )
    List<User2> findUserWithDeptId(Integer deptId);


    @Select("select * from t_user2 where id=#{id}")
    @Results(// 映射结果集 相当于配置文件中的resultMap
            {
                    @Result(id = true,column = "id",property = "id"),
                    @Result(column = "name",property = "name"),
                    @Result(column = "age",property = "age"),
                    // one = @One 表示一对一 需要关联其他Mapper接口中的查询方法
                    @Result(column = "addressId",property = "address"
                            ,one = @One(select = "com.etjava.mappers.AddressMapper.findById")),
                    // 查询用户带部门信息
                    @Result(column = "deptId",property = "dept",one = @One(select = "com.etjava.mappers.DeptMapper.findById"))
            }
    )
    List<User2> findUserWithDept(Integer id);

}
