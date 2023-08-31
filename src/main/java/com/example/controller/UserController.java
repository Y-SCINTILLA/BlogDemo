package com.example.controller;

import com.example.pojo.Article;
import com.example.pojo.Result;
import com.example.pojo.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired  //自动注入
    private UserService userService;

    @RequestMapping("/selectAll")
    public Result selectAll(){
        try {
            List<User> users= userService.selectAll();
            return new Result(200,"查询成功",users);
        } catch (Exception e) {
            return new Result(500,"查询失败",e);
        }
    }
    @RequestMapping("/register")
    public Result add(@RequestBody User user){
        Date date =new Date();
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        user.setRegistrationTime(df.format(date));
        String password= user.getPassword();
        String salt="114514";
        password=password+salt;
        password= DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8));
        user.setPassword(password);
        try{
            userService.add(user);
            return new Result(200,"注册成功");
        }catch (Exception e){
        e.printStackTrace();
        return new Result(500,"注册失败",e);
        }
    }
    @RequestMapping("/login")
    public Result login(@RequestBody User user , HttpSession session){
        User result=userService.selectBYUsername(user.getUsername());
        if(result==null){
            return new Result(300,"该用户未注册");

        }

        String password=user.getPassword();
        String salt="114514";
        password=password+salt;
        password=DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8));
        if(result.getPassword().equals(password)){
            session.setAttribute("uid",result.getUid());
            return new Result(200,"登入成功");
        }
        else{
            return new Result(300,"密码错误");
        }
    }
}
