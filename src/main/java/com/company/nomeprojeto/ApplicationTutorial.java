package com.company.nomeprojeto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.company.nomeprojeto")
public class ApplicationTutorial {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationTutorial.class, args);
        System.out.println("Running");
    }
}
