package com.yn.swaggerdemo.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ApiModel(value = "用户管理",description = "用户管理操作")
public class User {
    @ApiModelProperty(value = "用户名", name = "username")
    private String username;
    @ApiModelProperty(value = "密码", name = "password")
    private Integer password;
}
