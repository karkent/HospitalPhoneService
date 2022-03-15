package com.example.hospitalphoneservice.controller;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

import com.example.hospitalphoneservice.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api") //一级接口
public class UserController {

    private JSONObject objectTrue = new JSONObject();
    private JSONObject objectFalse = new JSONObject();


    public UserController() throws JSONException {
        objectTrue.put("result", true);
        objectFalse.put("result", false);
    }

    @ResponseBody
    @RequestMapping("/login") //二级接口
    public String login(String a, String b){
        System.out.println(a+"!!"+b);
        return objectTrue.toString();
    }
}
