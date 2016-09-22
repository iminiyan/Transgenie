package com.vedha.tgservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration 
@EnableAutoConfiguration
@ComponentScan

 // This class is the entry point of the application.
public class RestApplication   {

    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);

    }

}