package com.saspallow.demo.demo;

import com.google.gson.Gson;
import com.saspallow.demo.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dt213142 on 10/16/2017.
 */
@RestController
public class MyController {

    @Autowired
    Environment environment;

    @GetMapping("/test")
    public String index() {
        Gson gson = new Gson();
        String json = gson.toJson(new User("Surasak", 1, "dfdsfdsf"));
        return json;
    }

    @GetMapping("/")
    public String sayHi() {
        String port = environment.getProperty("server.port", "8080");

        return "running on port: " + port + "\n";
    }
}
