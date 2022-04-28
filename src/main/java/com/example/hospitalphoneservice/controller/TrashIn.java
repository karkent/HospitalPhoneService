package com.example.hospitalphoneservice.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.hospitalphoneservice.server.TrashInCheckServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrashIn {
    @Autowired
    TrashInCheckServer trashInCheck;
    @ResponseBody
    @PostMapping("/inCheck") //二级接口
    public String trashInCheck(String userId){
        return trashInCheck.boxNum(userId);
    }


    @ResponseBody
    @PostMapping("/trashIn") //二级接口
    public String trashIn(String trashIn){
        return trashInCheck.trashInMessage(trashIn);
    }


}
