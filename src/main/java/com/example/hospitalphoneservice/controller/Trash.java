package com.example.hospitalphoneservice.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.hospitalphoneservice.server.impl.TrashUpImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class Trash {
    @Autowired
    TrashUpImpl trashUpImpl;

    @ResponseBody
    @PostMapping("/upTrash") //
    public String trashUp(String upTrash){
       String a = trashUpImpl.upTrash(JSONObject.parseObject(upTrash));
        System.out.println(a+"@#$@#@#@#");
       return a;
    }
}
