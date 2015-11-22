package edu.sjsu.cmpe275Project.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by emy on 11/15/15.
 */
@SpringBootApplication
@ComponentScan(basePackages = {"edu.sjsu.cmpe275Project.controller", "edu.sjsu.cmpe275Project.configs","edu.sjsu.cmpe275Project.service",
"edu.sjsu.cmpe275Project.dao"})
public class MainApplication {

    public static void main(String[] args) {
            SpringApplication.run(MainApplication.class, args);
    }
}
