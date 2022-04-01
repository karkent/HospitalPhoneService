package com.example.hospitalphoneservice.server.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.hospitalphoneservice.bean.Trash;
import com.example.hospitalphoneservice.bean.Waring;
import com.example.hospitalphoneservice.mapper.TrashInCheckMapper;
import com.example.hospitalphoneservice.server.TrashInCheckServer;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TrashInCheckImpl implements TrashInCheckServer {

    @Autowired
    TrashInCheckMapper trashInCheckMapper;


    @Override
    public String boxNum(String userId) {
        List<Trash> trashes = trashInCheckMapper.trashNumCheck(userId);
        int boxNum = 0;
        Map<String,String> tMap= new HashMap<>();
        for (Trash t:trashes) {
            boxNum++;
            tMap.put(t.getBoxcode(),t.getBagcode());
        }
        Waring w = getWaring();
        String boxN ="箱数"+tMap.size()+"袋数"+boxNum;
        tMap.clear();
        tMap.put("boxN",boxN);
        tMap.put("waring",JSONObject.toJSONString(w));
        return JSONObject.toJSONString(tMap);
    }
    public Waring getWaring(){
        return  trashInCheckMapper.waring();
    }
}
