package com.jbrsm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@PropertySource(value = {
        "classpath:${spring.profiles.active}/application-${spring.profiles.active}.properties",
        "classpath:${spring.profiles.active}/config/jdbc.properties"
},encoding = "utf-8")
@SpringBootApplication
public class JbRsmApplication {

    public static void main(String[] args) {
        SpringApplication.run(JbRsmApplication.class, args);
    }

}
