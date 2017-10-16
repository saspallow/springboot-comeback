package com.saspallow.demo.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by dt213142 on 10/16/2017.
 */
public class ErrorControllerImpl implements ErrorController {

    private static final String PATH = "/api/error";

    @GetMapping(value = PATH)
    public String error(){
        return "Error handling";
    }
    @Override
    public String getErrorPath() {
        return PATH;
    }
}
