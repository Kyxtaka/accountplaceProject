package com.accountplace.api.API;

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

    @GetMapping("/infos")
    public String info() {
        return "PostgreSQL 14<br>Angular 17<br>Spring Boot 14<br>Maven 4.4.4";
    }



}


