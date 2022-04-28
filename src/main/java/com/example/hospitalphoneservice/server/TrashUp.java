package com.example.hospitalphoneservice.server;

import com.example.hospitalphoneservice.bean.User;

import java.util.Map;

public interface TrashUp {

    String upTrash(Map<String,Object> map);

    String localTrash(String localTrash);
}
