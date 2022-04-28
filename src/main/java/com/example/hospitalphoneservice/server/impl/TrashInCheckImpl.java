package com.example.hospitalphoneservice.server.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.hospitalphoneservice.bean.*;
import com.example.hospitalphoneservice.mapper.TrashInCheckMapper;
import com.example.hospitalphoneservice.server.TrashInCheckServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
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
        double weight = 0;
        Map<String,Object> tMap= new HashMap<>();
        for (Trash t:trashes) {
            boxNum++;
            weight+=Double.parseDouble(t.getWeight());
            System.out.println(t.getWeight());
            tMap.put(t.getBoxcode(),t.getBagcode());
        }
        Waring w = getWaring();
        String boxN ="箱数"+tMap.size()+"袋数"+boxNum;
        tMap.clear();
        tMap.put("boxN",boxN);
        tMap.put("waring",JSONObject.toJSONString(w));
        tMap.put("weight",String.valueOf(weight));
        return JSONObject.toJSONString(tMap);
    }
    public Waring getWaring(){
        return trashInCheckMapper.waring();
    }

    @Override
    public String trashInMessage(String msg){
        JSONObject tMap = JSONObject.parseObject(msg);
        User user = JSONObject.parseObject(tMap.get("user").toString(),User.class);
        Save save = JSONObject.parseObject(tMap.get("save").toString(),Save.class);
        List<Object> steam = JSONObject.parseArray(tMap.get("steam").toString());
        List<Trash> trashes = trashInCheckMapper.trashNumCheck(user.getStaffid());
        Double num = Double.parseDouble(String.valueOf(steam.get(2)))/Double.parseDouble(String.valueOf(trashes.size()));
        for (Trash t:trashes) {
            SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            t.setTime(dft.format(System.currentTimeMillis()));
            t.setWeight(num.toString());
            t.setUserId(user.getStaffid());
        }
        System.out.println(JSONObject.toJSONString(trashes)+"2313122131");
        int a = trashInCheckMapper.trashInTable(trashes);
        int b = trashInCheckMapper.trashTypeChange(user);
        if (steam.get(0).equals("3")){
            System.out.println(steam.get(1));
        }
        if (steam.get(0).equals("2")){
            System.out.println(steam.get(1));
        }
        if (steam.get(0).equals("1")){
            System.out.println(steam.get(1));
        }
        return "4555555";
    }
}
