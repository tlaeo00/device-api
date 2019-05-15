package com.example.deviceapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 스프링 부트 구동 (임베디드된 톰캣이 구동됨)
 */
@SpringBootApplication
public class DeviceApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeviceApiApplication.class, args);
    }

}
