package com.hwua.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class Springboot03MultidatasourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot03MultidatasourceApplication.class, args);
    }
}
