package com.example.hospitalphoneservice.server.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.hospitalphoneservice.bean.BoxCode;
import com.example.hospitalphoneservice.bean.UpTrashBean;
import com.example.hospitalphoneservice.bean.User;
import com.example.hospitalphoneservice.mapper.TrashUpMapper;
import com.example.hospitalphoneservice.server.TrashUp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class TrashUpImpl implements TrashUp {

    @Autowired
    TrashUpMapper trashUpMapper;

    @Override
    public String upTrash(Map<String,Object> map) {
        UpTrashBean upTrashBean = JSONObject.parseObject(map.get("trash").toString(), UpTrashBean.class);
        BoxCode beaox = JSONObject.parseObject(map.get("box").toString(),BoxCode.class);
        upTrashBean.setBoxcode(beaox.getBoxcode());
        User user = JSONObject.parseObject(map.get("user").toString(),User.class);
        upTrashBean.setCollect(user.getCollect());
        upTrashBean.setStaffid(user.getStaffid());
        upTrashBean.setState("6");
        SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        upTrashBean.setTime(dft.format(System.currentTimeMillis()));
        String f = null;
        //查询箱条码是否已使用 已使用报错 未使用正常添加
        //设置箱条码为已使用
        try {
            Integer check = trashUpMapper.upTrash(upTrashBean);
            if (check == 1){
                return "true";
            }else {
                return "false";
            }
        }catch (Exception e){
            f = e.toString();
            return "error"+f;
        }
    }
    @Override
    public String localTrash(String localTrash) {
        JSONArray beans = JSONObject.parseArray(localTrash);
        List<UpTrashBean> upTrashBeans = new ArrayList<>();
        for (int i = 0; i < beans.size(); i++) {
            UpTrashBean bean = new UpTrashBean();
            JSONObject jsonObject=beans.getJSONObject(i);
            bean.setState(jsonObject.getString("state"));
            bean.setBag(jsonObject.getString("bag"));
            bean.setBoxcode(jsonObject.getString("boxcode"));
            bean.setCollect(jsonObject.getString("collect"));
            bean.setDcode(jsonObject.getString("dcode"));
            bean.setDepidemic(jsonObject.getString("depidemic"));
            bean.setStaffid(jsonObject.getString("staffid"));
            bean.setTime(jsonObject.getString("time"));
            bean.setTypeId(jsonObject.getString("typeId"));
            bean.sethName(jsonObject.getString("hName"));
            bean.setWeight(jsonObject.getString("weight"));
            upTrashBeans.add(bean);
        }
        int a  = trashUpMapper.localTrash(upTrashBeans);
        if (a>0){
            return String.valueOf(a);
        }else {
            return "false";
        }
    }
}

