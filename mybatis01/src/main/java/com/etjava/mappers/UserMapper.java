package com.etjava.mappers;

import com.etjava.model.User;

import java.util.List;

public interface UserMapper {
    /**
     * 查询所有用户，同时获取到用户下所有账户的信息
     * @return
     */
    List<User> findAll();
}
