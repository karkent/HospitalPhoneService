package com.example.hospitalphoneservice.server.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.hospitalphoneservice.bean.Hospital;
import com.example.hospitalphoneservice.bean.Pdarole;
import com.example.hospitalphoneservice.bean.Staffrole;
import com.example.hospitalphoneservice.bean.User;
import com.example.hospitalphoneservice.mapper.UserLoginMapper;
import com.example.hospitalphoneservice.server.LoginServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springfox.documentation.spring.web.json.Json;
import sun.misc.BASE64Decoder;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        List<User> users = userLoginMapper.loginCheck(user);
        if (users.size()>0){
            for (User useres:users) {
                user.setStaffid(useres.getStaffid());
                user.setSjobnum(useres.getSjobnum());
                user.setSname(useres.getSname());
                user.setSstate(useres.getSstate());
                user.setHid(useres.getHid());
            }
            //did 科室判断是否为后勤保障科室 hid 获取医院名字 staffrole表查菜单角色
            if (Integer.valueOf(user.getSstate()) == 2){

                List<Staffrole> staffroles = userLoginMapper.userStaff(Integer.parseInt(user.getStaffid()));
                for (Staffrole staffrole:staffroles){
                    if (staffrole.getRolename().contains("后勤")||staffrole.getRolename().contains("收废")){
                        Map<String,Object> map = new HashMap<>();
                         List<Hospital> hospital = userLoginMapper.hospital(Integer.parseInt(user.getHid()));
                         for (Hospital hospital1:hospital){
                            if (hospital1.getHstate().equals("2")){
                                List<Pdarole> pdaroles = userLoginMapper.pda(Integer.parseInt(staffrole.getRoleid()));
                                map.put("pda",JSONObject.toJSONString(pdaroles));
                                map.put("user",JSONObject.toJSONString(user));
                                map.put("hospital",JSONObject.toJSONString(hospital1));
                                System.out.println(JSONObject.toJSONString(map));
                                return JSONObject.toJSONString(map);
                            }else {
                                return "state";
                            }
                         }
                    }else {
                        return "state";
                    }
                }
            }else {
                return "state";
            }
            return "FatalError";
        }else {
            System.out.println("1");
            return "UnKnowUser";
        }
    }
}
