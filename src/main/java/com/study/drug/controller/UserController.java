package com.study.drug.controller;

import com.study.drug.common.ResultMapUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
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
        if (username==null||password==null){
            return ResultMapUtil.getHashMapLogin("用户名和密码不能为空","2");
        }

        //结合Shiro实现登录验证
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        try{
            subject.login(token);
        }catch (UnknownAccountException e){
            //code:2  失败
            return ResultMapUtil.getHashMapLogin("用户名不存在","2");
        }catch (IncorrectCredentialsException e){
            return ResultMapUtil.getHashMapLogin("密码错误","2");
        }
        return ResultMapUtil.getHashMapLogin("登录成功","1");
    }

    /**
     * 去后台管理首页
     */
    @GetMapping("/index")
    public String index(){

        return "index";
    }
}
