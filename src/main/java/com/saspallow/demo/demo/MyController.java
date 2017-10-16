package com.saspallow.demo.demo;

import com.google.gson.Gson;
import com.saspallow.demo.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Value("${server.contextPath}")
    String contextPath;

    @Value("${spring.application.name}")
    String appName;


    @Autowired
    Environment environment;

    @GetMapping("/user")
    public String index() {
        return new Gson().toJson(new User("Surasak", 1, "Bangkok, Thailand"));
    }

    @GetMapping("/")
    public String sayHi() {
        String port = environment.getProperty("server.port", "8080");
        String.format("App Name, %s \n", appName);

        return String.format("App Name: %s \n", appName)+
                String.format(", Context Path: %s \n", contextPath)+
                        String.format(", Running on port: %s \n", port);
    }
}
