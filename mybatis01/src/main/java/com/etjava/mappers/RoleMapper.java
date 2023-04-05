package com.etjava.mappers;

import com.etjava.model.Role;

import java.util.List;

public interface RoleMapper {
    /**
     * 查询所有角色
     * @return
     */
    List<Role> findAll();
}
