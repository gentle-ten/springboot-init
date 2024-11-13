package com.init.model.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;


@Schema(name = "UserRegisterDTO", description = "用户注册请求体")
@Data
public class UserRegisterDTO implements Serializable {

    @Schema(name = "userAccount", description = "用户账号")
    @NotBlank(message = "用户账号不能为空")
    @Size(min = 4, max = 16, message = "用户账号长度在4-16之间")
    private String userAccount;

    @Schema(name = "userPassword", description = "用户密码")
    @NotBlank(message = "用户密码不能为空")
    @Size(min = 8, message = "用户密码不能少于 8 位")
    private String userPassword;

    @Schema(name = "checkPassword", description = "校验用户密码")
    @NotNull(message = "校验用户密码不能为空")
    @Size(min = 8, message = "用户密码不能少于 8 位")
    private String checkPassword;


    private static final long serialVersionUID = 3191241716373120793L;
}
