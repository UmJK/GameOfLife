package com.chargepoint.gameOfLife;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class GameOfLifeApplication {

    public static void main(String[] args) {
        SpringApplication.run(GameOfLifeApplication.class, args);
    }
}