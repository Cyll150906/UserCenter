package com.wxy.usercenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wxy.usercenter.mapper.UserMapper;
import com.wxy.usercenter.model.User;
import com.wxy.usercenter.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author w1309
 * @description 针对表【user(用户)】的数据库操作Service实现
 * @createDate 2024-03-26 21:35:44
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public long userRegister(String userAccount, String userPassword, String checkPassword) {
        // 1、校验
        if (StringUtils.isAllBlank(userAccount, userPassword, checkPassword)) {
            return -1;
        }
        if (userAccount.length() < 4) {
            return -1;
        }
        if (userPassword.length() < 8 || checkPassword.length() < 8) {
            return -1;
        }

        // 账户不能包含特殊字符
        String vaildPattern = "\\pP|\\pS|\\s+";
        Matcher matcher = Pattern.compile(vaildPattern).matcher(userAccount);
        if (!matcher.find()) {
            return -1;
        }
        // 密码与校验密码相同

        if (!userPassword.equals(checkPassword)) {
            return -1;
        }
        // 账户不重复
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userAccount", userAccount);
        long count = userMapper.selectCount(queryWrapper);
        if (count > 0) {
            return -1;
        }
        // 2.加密
        final String sALT = "wxy";
        String newPassword = DigestUtils.md5DigestAsHex((sALT + userPassword).getBytes());
        // 3插入数据
        User user = new User();
        user.setUserAccount(userAccount);
        user.setUserPassword(userPassword);
        boolean saveResult = this.save(user);
        if (!saveResult){
            return -1;
        }
        return user.getId();
    }
}




