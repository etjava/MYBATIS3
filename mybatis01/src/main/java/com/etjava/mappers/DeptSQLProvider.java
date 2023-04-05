package com.etjava.mappers;

import com.etjava.model.Dept;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class DeptSQLProvider {

    public String findAll(final Map<String,Object> map){
        return new SQL(){
            {
                SELECT("*");
                FROM("t_dept");
                // 自己拼接SQL
                StringBuffer buf = new StringBuffer();
                if(map.get("deptName")!=null){
                    buf.append("and deptName='"+map.get("deptName")+"'");
                }
                if(!buf.toString().equals("")){
                    WHERE(buf.toString().replaceFirst("and",""));
                }
            }
        }.toString();
    }

    public String selectById(){
        return new SQL(){
            {
                SELECT("id,deptName");// 可以使用通配符 也可以手动写所需要的列
                FROM("t_dept");
                WHERE("id=#{id}");
            }
        }.toString();
    }

    // 根据ID删除学生 final Integer id  可以不写 因为可以使用#{id} 方式直接取值
    public String deleteDept(){
        return new SQL(){
            {
                DELETE_FROM("t_dept");
                WHERE("id=#{id}");
            }
        }.toString();
    }

    public String updateDept(final Dept d){
        return new SQL(){
            {
                UPDATE("t_dept");
                if(d.getDeptName()!=null){
                    SET("deptName=#{deptName}");
                }
                WHERE("id=#{id}");
            }
        }.toString();
    }

    // 这里如果传递参数 必须final修饰
    public String insertDept(final Dept dept){
        return new SQL(){
            // 这里需要动态拼接是SQL
            {
                INSERT_INTO("t_dept");
                if(dept.getDeptName()!=null){
                    // 如果insertDept方法 没有传递参数 可以直接通过#{name} 方式赋值
                    // 如果是直接赋值 需要两边添加单引号
                    VALUES("deptName","#{deptName}");
                }
            }
        }.toString();
    }
}
