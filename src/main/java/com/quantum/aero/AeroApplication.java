package com.quantum.aero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AeroApplication {

    public static void main(String[] args) {
        System.out.println(".....  aero app  .....");
        SpringApplication.run(AeroApplication.class, args);
    }

}