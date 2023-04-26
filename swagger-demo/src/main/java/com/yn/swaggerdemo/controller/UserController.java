package com.yn.swaggerdemo.controller;

import com.yn.javacommon.api.CommonResult;
import com.yn.swaggerdemo.domain.User;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "第一个swagger整合测试案例", value = "该参数没什么意义，在UI界面上也看到，所以不需要配置")
public class UserController {


    @ApiOperation(value = "查询用户信息", httpMethod = "GET", notes = "查询用户信息")
    @ApiParam(value = "ID of user that needs to be fetched", allowableValues = "range[1,10]", required = true)
    @GetMapping("/findByUserItem/{id}")
    public User findByUserItem(@PathVariable("id") Long id) {
        User user = new User();
        user.setAge(18).setPassword(12345).setUsername("张三");
        return user;
    }

    @ApiImplicitParams({
            //参数效验
            @ApiImplicitParam(name = "mobile", value = "手机号", required = true, paramType = "form"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, paramType = "form"),
            @ApiImplicitParam(name = "age", value = "年龄", required = true, paramType = "form", dataType = "Integer")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "请求成功"),
            @ApiResponse(code = 400, message = "请求参数没填好"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")
    })
    @ApiOperation(value = "登录", httpMethod = "POST", notes = "用户登录")
    @PostMapping("/login")
    public CommonResult login(@RequestParam String mobile, @RequestParam String password,
                              @RequestParam Integer age) {
        User user = new User();
        user.setUsername("王五").setAge(25).setMobile(18229840699L);
        return CommonResult.success(user);
    }
}
