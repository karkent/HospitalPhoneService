package com.example.hospitalphoneservice.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

import com.example.hospitalphoneservice.bean.User;
import com.example.hospitalphoneservice.server.impl.LoginImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserUp {

    @Autowired
    LoginImpl loginImpl;

    @ResponseBody
    @PostMapping("/login") //二级接口
    public String login(String userLogin){
        String msg = null;
       try {
           User user = JSONObject.parseObject(userLogin,User.class);
           msg = loginImpl.LoginCheck(user);
           return msg;
       }catch (Exception e) {
           System.out.println(e);
       }
       return "UnKnowUser";
    }

}
