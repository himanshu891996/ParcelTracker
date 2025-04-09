package org.himanshu;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // This annotation enables Spring Boot's auto-configuration and component scanning
public class Main {

    public static void main(String[] args) {
        // This method will start the Spring Boot application
        SpringApplication.run(Main.class, args);
    }
}
