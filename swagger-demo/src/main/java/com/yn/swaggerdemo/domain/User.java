package com.yn.swaggerdemo.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ApiModel(value="user对象",description="用户对象user")
public class User {
    @ApiModelProperty(value="用户名",name="username",example="郭靖")
    private String username;
    @ApiModelProperty(value="密码",name="password",required=true)
    private Integer password;
    @ApiModelProperty(value="年龄",hidden=true)
    private Integer age;
    @ApiModelProperty(value="手机号",example="18229840699")
    private Long mobile;
}
