package com.jbrsm.bean;

import java.util.Date;

public class Student {
    private String name;
    private Date CreatDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatDate() {
        return CreatDate;
    }

    public void setCreatDate(Date creatDate) {
        CreatDate = creatDate;
    }
}
