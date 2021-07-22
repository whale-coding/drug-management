package com.study.drug.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.study.drug.pojo.User;

/**
 * 用户表的service接口
 */
public interface UserService extends IService<User> {
    /**
     * 根据用户名查询用户对象
     */
    public User queryUserByUsername(String username);

}
