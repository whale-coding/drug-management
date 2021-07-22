package com.study.drug.controller;

import com.study.drug.common.ResultMapUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户相关的controller
 */
@Controller
public class UserController {

    /**
     * 去登录页面
     */
    @RequestMapping("/toLogin")
    public String login(){
        return "login";
    }

    /**
     * 判断用户登录是否成功
     */
    @PostMapping("/login")
    @ResponseBody
    public Object login(String username,String password){

        return ResultMapUtil.getHashMapLogin("验证成功","1");
    }

    /**
     * 去后台管理首页
     */
    @GetMapping("/index")
    public String index(){

        return "index";
    }
}
