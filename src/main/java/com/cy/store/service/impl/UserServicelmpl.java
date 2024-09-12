package com.cy.store.service.impl;

import com.cy.store.entity.User;
import com.cy.store.mapper.UserMapper;
import com.cy.store.service.IUserService;
import com.cy.store.service.ex.InsertException;
import com.cy.store.service.ex.PasswordNotMatchException;
import com.cy.store.service.ex.UsernameDuplicatedException;
import com.cy.store.service.ex.UsernameNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.UUID;

@Service
public class UserServicelmpl implements IUserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public void reg(User user) {
        //1、判断用户名是否重复
        String username = user.getUsername();
        User fault=userMapper.findByUsername(username);
        if(fault!=null){
            throw new UsernameDuplicatedException("用户名被占用");
        }

        //处理密码加密，获取盐值(随机生成)
        String oldPassword = user.getPassword();
        String salt = UUID.randomUUID().toString().toUpperCase();//随机获取一个字符串作为盐值
        user.setSalt(salt);
        String md5Password = getMD5Password(oldPassword, salt);
        user.setPassword(md5Password);


        user.setIsDelete(0);

        user.setCreatedUser(user.getUsername());
        user.setModifiedUser(user.getUsername());
        Date date = new Date();
        user.setCreatedTime(date);
        user.setModifiedTime(date);

        Integer rows = userMapper.insert(user);
        if (rows!=1){// 插入数据时产生未知的异常，导致没有正常返回
            throw new InsertException("注册时产生未知的异常");
        }
    }

    @Override
    public User login(String username, String password) {
        User result = userMapper.findByUsername(username);
        if(result==null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        String oldPassword = result.getPassword();
        String salt = result.getSalt();
        String md5Password = getMD5Password(password, salt);
        if(!md5Password.equals(oldPassword)){
            throw new PasswordNotMatchException("密码错误");
        }
        if(result.getIsDelete()==1){
            throw new UsernameNotFoundException("用户名不存在");
        }

        return result;
    }

    private String getMD5Password(String password,String salt){
        for(int i=0;i<3;i++)
        {
            password=DigestUtils.md5DigestAsHex((salt+password+salt).getBytes()).toUpperCase();
        }
        return password;
    }
}
