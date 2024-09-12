package com.cy.store.service;

import com.cy.store.entity.User;

/*用户服务层*/
public interface IUserService {
    void reg(User user);//用户注册

    User login(String username, String password);//用户登录
}
