package com.example.hospitalphoneservice;


import jxl.write.DateTime;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class HospitalPhoneServiceApplicationTests {

    @Test
    void contextLoads() {

        System.out.println(unitFormat2(1));
    }
    public static String unitFormat2(int i) {// 毫秒的格式转换
        String retStr = null;
        if (i >= 0 && i < 10)
            retStr = "00" + Integer.toString(i);
        else if (i >= 10 && i < 100) {
            retStr = "0" + Integer.toString(i);
        } else
            retStr = "" + i;
        return retStr;
    }

}
