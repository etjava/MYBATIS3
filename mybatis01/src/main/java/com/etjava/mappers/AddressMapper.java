package com.etjava.mappers;

import com.etjava.model.Address;

public interface AddressMapper {

    // 根据ID查询地址信息
    public Address findById(Integer id);
}
