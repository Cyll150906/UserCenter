package com.wxy.usercenter.service;

import com.wxy.usercenter.model.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author w1309
* @description 针对表【user(用户)】的数据库操作Service
* @createDate 2024-03-26 21:35:44
*/
public interface UserService extends IService<User> {
    /**
     *
     * @param userAccount 用户账户
     * @param userPassword 用户密码
     * @param checkPassword 校验密码
     * @return
     */
    long userRegister(String userAccount,String userPassword,String checkPassword);
}
