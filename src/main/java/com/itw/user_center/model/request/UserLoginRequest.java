package com.itw.user_center.model.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户登录请求体
 *
 * @author notbug
 */
@Data
public class UserLoginRequest implements Serializable {

    private static final long serialVersionUID = 2669293150219020249L;

    private String userAccount;

    private String userPassword;



}
