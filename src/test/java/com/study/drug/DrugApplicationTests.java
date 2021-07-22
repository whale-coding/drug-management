package com.study.drug;


import com.study.drug.mapper.UserMapper;
import com.study.drug.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class DrugApplicationTests {

    @Resource
    private UserService userService;

    @Resource
    private UserMapper userMapper;

    @Test
    public void test1(){
        System.out.println(userService.queryUserByUsername("admin"));
    }


}
