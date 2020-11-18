package com.jbrsm.service;

import cn.hutool.core.date.DateUtil;
import com.jbrsm.bean.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.RejectedExecutionHandler;

@SpringBootTest
class TestServiceTest {

    @Autowired
    private TestService testService;

    @Test
    public void test01(){
        testService.test01();
    }
    @Test
    public void test02(){
        String dateStr1 = "2020-01-24";
        String dateStr2 = "2020-01-23";
        Date date1 = DateUtil.parse(dateStr1);
        Date date2 = DateUtil.parse(dateStr2);

        Student student1 = new Student();
        Student student2 = new Student();

        student1.setName("aaa");
        student2.setName("bbb");
        student1.setCreatDate(date1);
        student2.setCreatDate(date2);

        List<Student> studentList = new ArrayList<>();
        //studentList.add(student1);
        //studentList.add(student2);

        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getCreatDate().compareTo(o2.getCreatDate());
                //return 0;
            }
        });

        studentList.forEach(student -> System.out.println(student.getName()));

    }

    @Test
    public void test03(){
        List<String> strs = new ArrayList<>();
        String s1 = "qqqqqqqqq";
        String s2 = "wwwwwwwwwww";
        String s3 = "eeeeeeeeeeee";
        strs.add(s1);
        strs.add(s2);
        strs.add(s3);

        String s4 = listToString(strs);
        System.out.println(s4);
    }
    private static String listToString(List<String> list) {
        if (list != null && list.size() > 0) {
            StringBuffer sb = new StringBuffer();
            sb.append("(");
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i));
                if (i < list.size() - 1) {
                    sb.append(",");
                }
            }
            sb.append(")");
            return sb.toString();
        }
        return null;
    }
    @Test
    public void test04(){
        BigDecimal b = new BigDecimal("10623.36");
        BigDecimal c = b.divide(new BigDecimal("10000"),1, BigDecimal.ROUND_HALF_UP);
        System.out.println(c.toString());
        BigDecimal d = new BigDecimal("1");
        System.out.println(c.compareTo(d));
    }
    @Test
    public void test05(){
        Date now = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(now);
        c.add(Calendar.MONTH, -1);
        Date lastMouth = c.getTime();
        String lastMouthStr = new SimpleDateFormat("MM").format(lastMouth);
        lastMouthStr = "确认" + lastMouthStr + "月数据已上传完毕";
        System.out.println(lastMouthStr);
    }
    @Test
    public void test06() throws ParseException {
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date2 = sdf.parse("2020-02-01 00:00:00");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date2);
        calendar.add(Calendar.SECOND,-1);
        Date date3 = calendar.getTime();
        System.out.println(sdf.format(date3));
    }
    @Test
    public void test07(){

    }
}