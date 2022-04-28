package com.example.hospitalphoneservice.mapper;

import com.example.hospitalphoneservice.bean.Hospital;
import com.example.hospitalphoneservice.bean.Pdarole;
import com.example.hospitalphoneservice.bean.Staffrole;
import com.example.hospitalphoneservice.bean.User;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserLoginMapper {

    List<User> loginCheck(User user);

    List<Staffrole> userStaff(int staffid);

    List<Hospital> hospital(int hid);

    List<Pdarole> pda(int roleid);
}
