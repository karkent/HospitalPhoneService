package com.example.hospitalphoneservice.controller;

import com.example.hospitalphoneservice.server.impl.TrashUpImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Trash {
    @Autowired
    TrashUpImpl trashUpImpl;

    @ResponseBody
    @PostMapping("/upTrash") //二级接口
    public boolean trashUp(String user,String trashUp,String boxCode){
        return trashUpImpl.upTrash(user,trashUp,boxCode);
    }
}
