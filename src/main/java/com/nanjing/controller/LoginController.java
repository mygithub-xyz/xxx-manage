package com.nanjing.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/show")
@Api(tags = "首页显示登录人")
public class LoginController {
    //获取当前登录用户名
    @GetMapping("/showName")
    @ApiOperation("显示登录人")
    public Map showLoginName() {
        //使用springSecurity获取当前登录用户名
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        Map map = new HashMap();
        map.put("loginName", name);
        return map;
    }

}
