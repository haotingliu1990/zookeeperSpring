package com.haotliu.zookeeper.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController implements ErrorController {
    @RequestMapping("error")
    public String handleException(){
        return "error";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
