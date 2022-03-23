package com.example.hospitalphoneservice.server.impl;

import com.example.hospitalphoneservice.server.TrashUp;
import org.springframework.stereotype.Service;

@Service
public class TrashUpImpl implements TrashUp {

    @Override
    public Boolean upTrash(String user, String trashUp, String boxCode) {
        System.out.println(user+"@"+trashUp+"@"+boxCode);
        return null;
    }
}
