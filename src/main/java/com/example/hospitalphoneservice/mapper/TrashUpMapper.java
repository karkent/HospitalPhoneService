package com.example.hospitalphoneservice.mapper;

import com.alibaba.fastjson.JSONArray;
import com.example.hospitalphoneservice.bean.UpTrashBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrashUpMapper {
    Integer upTrash(UpTrashBean upTrashBean);

    int localTrash (List<UpTrashBean> upTrashBeans);
}
