package com.example.hospitalphoneservice.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.hospitalphoneservice.server.TrashUp;
import com.example.hospitalphoneservice.server.impl.TrashUpImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class Trash {
    @Autowired
    TrashUp trashUpImpl;

    @ResponseBody
    @PostMapping("/upTrash") //
    public String trashUp(String upTrash){
       String a = trashUpImpl.upTrash(JSONObject.parseObject(upTrash));
       return a;
    }


    @ResponseBody
    @PostMapping("/localTrash") //二级接口
    public String localTrash(String localTrash){
        return trashUpImpl.localTrash(localTrash);
    }
}
