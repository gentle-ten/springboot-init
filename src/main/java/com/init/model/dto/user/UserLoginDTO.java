package com.init.model.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户登录请求
 */
@Schema(name = "UserLoginDTO", description = "用户登录请求")
@Data
public class UserLoginDTO implements Serializable {

    @Schema(name = "userAccount", description = "用户账户")
    private String userAccount;


    @Schema(name = "userPassword", description = "用户密码")
    private String userPassword;


    private static final long serialVersionUID = 3191241716373120793L;
}
