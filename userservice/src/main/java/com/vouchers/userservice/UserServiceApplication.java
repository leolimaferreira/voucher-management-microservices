package com.vouchers.userservice;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {
        "com.vouchers.userservice",
        "com.vouchers.common.handler"
})
@SpringBootApplication
public class UserServiceApplication {

    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.configure()
                .directory("env")
                .ignoreIfMalformed()
                .ignoreIfMissing()
                .load();

        dotenv.entries().forEach(entry ->
                System.setProperty(entry.getKey(), entry.getValue())
        );
        SpringApplication.run(UserServiceApplication.class, args);
    }
}
