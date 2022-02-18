package com.example.web_sell_fruit;

import com.example.web_sell_fruit.configuration.SecurityConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class WebSellFruitApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebSellFruitApplication.class, args);
    }

}