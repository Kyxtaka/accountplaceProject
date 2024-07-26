package com.accountplace.api.controller;

import com.accountplace.api.service.AccountService;
import com.accountplace.api.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/user")
public class User {
    @Autowired
    private AccountService accountService;

    @Autowired
    private GroupService groupService;

    @GetMapping("/getAllUser")
    public String user() {
        return "All users";
    }

    @GetMapping("/infos")
    public String info() {
        return "PostgreSQL 14<br>Angular 17<br>Spring Boot 14<br>Maven 4.4.4";
    }

    @GetMapping("/testUser")
    public String testUser() {
        return accountService.getAccountById(0).toString();
    }

    @GetMapping("/getUser/{id}")
    public String testUser(@PathVariable int id) {
        return accountService.getAccountById(id).toString();
    }



}


