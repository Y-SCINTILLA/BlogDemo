package com.example;

import com.example.mapper.UserMapper;
import com.example.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MybatisTest {
    @Autowired
    public UserMapper userMapper;
    @Test
    public void userTest(){
        List<User> users=userMapper.selectAll();
        System.out.println(users);
    }
}
