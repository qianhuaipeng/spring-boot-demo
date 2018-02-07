package com.example;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * author: alan.peng
 * description:
 * date: create in 16:19 2018/2/6
 * modified By：
 */
@EnableAdminServer
@SpringBootApplication
public class Application  {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
