package com.example.hospitalphoneservice.mapper;

import com.example.hospitalphoneservice.bean.UpTrashBean;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface TrashUpMapper {
    Integer upTrash(UpTrashBean upTrashBean);
}
