package com.example.hospitalphoneservice.mapper;

import com.example.hospitalphoneservice.bean.Trash;
import com.example.hospitalphoneservice.bean.UpTrashBean;
import com.example.hospitalphoneservice.bean.User;
import com.example.hospitalphoneservice.bean.Waring;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrashInCheckMapper {
    List<Trash> trashNumCheck(String userId);

    Waring waring();

    int trashTypeChange(User user);

    int trashInTable(List<Trash> trash);

}
