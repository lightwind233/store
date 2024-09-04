package com.cy.store.mapper;

import com.cy.store.entity.User;

//用户模块持久层接口
public interface UserMapper {


    Integer insert(User user);//插入用户数据，返回受影响的行数

    User findByUsername(String username);//根据用户名查询用户数据,返回用户数据,没有找到就返回null

}
