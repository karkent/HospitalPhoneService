package com.example.hospitalphoneservice.server.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.hospitalphoneservice.bean.User;
import com.example.hospitalphoneservice.mapper.UserLoginMapper;
import com.example.hospitalphoneservice.server.LoginServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springfox.documentation.spring.web.json.Json;
import sun.misc.BASE64Decoder;

import java.io.IOException;
import java.util.List;

@Service
public class LoginImpl implements LoginServer {

    @Autowired
    UserLoginMapper userLoginMapper;

    @Override
    public String LoginCheck(User user){
        byte[] bytes;
        String decode = null;
        try {
            bytes = new BASE64Decoder().decodeBuffer(user.getSname());
            decode = new String(bytes, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        user.setSname(decode);
        System.out.println(user.getSname()+"@"+user.getStaffid()+"@"+user.getSjobnum());
        List<User> users = userLoginMapper.loginCheck(user);
        if (users.size()>0){
            for (User useres:users) {
                user.setStaffid(useres.getStaffid());
                user.setSjobnum(useres.getSjobnum());
                user.setSname(useres.getSname());
            }
            return JSONObject.toJSONString(user);
        }else {
            return "UnKnowUser";
        }
    }
}
