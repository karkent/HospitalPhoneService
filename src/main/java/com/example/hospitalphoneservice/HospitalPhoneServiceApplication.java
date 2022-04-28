package com.example.hospitalphoneservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan("com.example.hospitalphoneservice.mapper")
public class HospitalPhoneServiceApplication  {
//    extends SpringBootServletInitializer
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        return builder.sources(HospitalPhoneServiceApplication.class);
//    }

    public static void main(String[] args) {
        SpringApplication.run(HospitalPhoneServiceApplication.class, args);
    }

}
