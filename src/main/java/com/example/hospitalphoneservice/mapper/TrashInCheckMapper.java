package com.example.hospitalphoneservice.mapper;

import com.example.hospitalphoneservice.bean.Trash;
import com.example.hospitalphoneservice.bean.Waring;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrashInCheckMapper {
    List<Trash> trashNumCheck(String userId);

    Waring waring();
}
