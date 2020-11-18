package com.jbrsm;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.Date;

@SpringBootTest
class JbRsmApplicationTests {

    @Test
    void contextLoads() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.YEAR, -2);
        Date d = c.getTime();
        System.out.println(d);
    }

    public int test01(int n){
        if (n == 1 || n == 2){
            return 1;
        }else {
            return test01(n-1) + test01(n-2);
        }
    }


}
