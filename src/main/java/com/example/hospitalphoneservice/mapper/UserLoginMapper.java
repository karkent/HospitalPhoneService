package com.example.hospitalphoneservice.mapper;

import com.example.hospitalphoneservice.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserLoginMapper {

    List<User> loginCheck(User user);

}
