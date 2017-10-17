package com.saspallow.demo.controller;

import com.google.gson.Gson;
import com.saspallow.demo.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dt213142 on 10/17/2017.
 */
@RestController
public class UserController {

    @GetMapping("/user")
    public String getUser() {
        return new Gson().toJson(new User("Surasak", 1, "Bangkok, Thailand"));
    }

}
