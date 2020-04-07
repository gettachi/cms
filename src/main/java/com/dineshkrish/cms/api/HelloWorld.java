package com.dineshkrish.cms.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
    public String hello(){
        return "Hello Worl";
    }
}
