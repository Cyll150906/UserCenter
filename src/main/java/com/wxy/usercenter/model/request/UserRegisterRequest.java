package com.wxy.usercenter.model.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @author w1309
 */
@Data
public class UserRegisterRequest implements Serializable {

    private static final long serialVersionUID = 1959553359815805342L;

    private String userAccount;
    private String userPassword;
    private String checkPassword;
}
