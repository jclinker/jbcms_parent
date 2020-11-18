package com.jbrsm.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Value("${spring.datasource.druid.driver-class-name}")
    private String name;

    public void test01(){
        System.out.println(name);
    }
}
