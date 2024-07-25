package com.accountplace.api.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
@RequestMapping("/user")
public class User {

    @GetMapping("/getAllUser")
    public String user() {
        return "All users";
    }

    @GetMapping("/infos")
    public String info() {
        return "PostgreSQL 14<br>Angular 17<br>Spring Boot 14<br>Maven 4.4.4";
    }



}


