package com.nanjing.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

;


@Controller
@RequestMapping("/user")
@Api(tags = "首页跳转")
public class IndexController {
    @PostMapping("/index")
    @ApiOperation("跳转首页")
    public String index() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        return "redirect:/index.html";
    }
}
