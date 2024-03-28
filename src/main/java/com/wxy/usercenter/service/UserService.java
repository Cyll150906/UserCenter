package com.wxy.usercenter.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wxy.usercenter.model.User;

import javax.servlet.http.HttpServletRequest;

/**
 * @author w1309
 * &#064;description  针对表【user(用户)】的数据库操作Service
 * &#064;createDate  2024-03-26 21:35:44
 */
public interface UserService extends IService<User> {

    /**
     * 用户登录态的KEY
     */

    /**
     * @param userAccount   用户账户
     * @param userPassword  用户密码
     * @param checkPassword 校验密码
     * @return 新用户的ID
     */
    long userRegister(String userAccount, String userPassword, String checkPassword);

    /**
     * @param userAccount  用户账户
     * @param userPassword 用户密码
     * @param request      访问请求
     * @return 脱敏后的用户信息
     */
    User userLogin(String userAccount, String userPassword, HttpServletRequest request);

    /**
     *
     * @param originUser 用户信息
     * @return 脱敏后的脱敏信息
     */
    User getSafetyUser(User originUser);
}
