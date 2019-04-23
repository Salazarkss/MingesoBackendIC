package com.mingeso.ic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages="com.mingeso.ic")
@ComponentScan("com.mingeso.ic.repository")
public class MingesoIcApplication {

    public static void main(String[] args) {
        SpringApplication.run(MingesoIcApplication.class, args);
    }

}
