package com.cy.store.service;

import com.cy.store.entity.User;

/**用户模块业务层接口*/
public interface IUserService {
    /**
     * 用户注册方法
     * @param user 用户的数据对象
     */
    void reg(User user);

    /**
     * 用户登录功能
     * @param username 用户名
     * @param password 用户密码
     * @return 当前匹配的用户数据,如果没有则返回null
     */
    User login(String username,String password);

    /**
     * changePassword方法需要什么参数:
     * 要先看底层持久层需要什么参数:uid,password,modifiedUser,modifiedTime
     * 1.修改人其实就是username,已经保存到session当中,通过控制层传递过来就行了
     * 2.在更新数据之前需要先根据uid查这个数据存不存在,uid也可以通过控制层传递
     * 3.新密码需要有
     * 4.修改时间不需要在参数列表,直接在方法内部new Date()就可以了
     * 5.旧密码
     * */
    void changePassword(Integer uid,
                       String username,
                       String oldPassword,
                       String newPassword);

    /**
     * 根据用户的uid查询用户数据
     * @param uid 用户uid
     * @return 用户数据
     */
    User getByUid(Integer uid);

    /**
     * uid通过控制层在session中获取然后传递给业务层,并在业务层封装到User对象中
     * */
    void changeInfo(Integer uid,User user);

    /**
     * 修改用户的头像
     * @param uid 用户uid
     * @param avatar 用户头像的路径
     * @param username 用户名称
     */
    void changeAvatar(Integer uid,
                      String avatar,
                      String username);//业务层一般叫username而不叫modifiedUser,因
                                        // 为业务层并没有直接和数据库关联
}
