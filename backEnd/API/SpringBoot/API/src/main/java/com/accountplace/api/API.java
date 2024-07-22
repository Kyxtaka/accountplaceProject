package com.accountplace.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController("/")
public class API {

    @GetMapping("/")
    public String home() {
        return "Hello World";
    }

    @GetMapping("/user")
    public String user() {
        return "All users";
    }


}


