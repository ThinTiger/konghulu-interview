package com.konghulu.interview.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.konghulu.**"})
public class KonghuluInterviewApplication {

    public static void main(String[] args){
        SpringApplication.run(KonghuluInterviewApplication.class);
    }
}
