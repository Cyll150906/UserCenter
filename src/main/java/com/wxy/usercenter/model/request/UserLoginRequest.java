package com.wxy.usercenter.model.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @author w1309
 */
@Data
public class UserLoginRequest implements Serializable {


    private static final long serialVersionUID = -2743540071630909389L;
    private String userAccount;
    private String userPassword;
}
