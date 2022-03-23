package com.example.hospitalphoneservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.hospitalphoneservice.mapper")
public class HospitalPhoneServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalPhoneServiceApplication.class, args);
    }

}
