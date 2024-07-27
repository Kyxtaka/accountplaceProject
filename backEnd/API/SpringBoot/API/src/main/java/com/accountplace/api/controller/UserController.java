package com.accountplace.api.controller;

import com.accountplace.api.domains.EntiteAccount;
import com.accountplace.api.dto.AccountDto;
import com.accountplace.api.service.AccountService;
import com.accountplace.api.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    private AccountService accountService;

    @Autowired
    private GroupService groupService;



    @GetMapping("/infos")
    public String info() {
        return "PostgreSQL 14<br>Angular 17<br>Spring Boot 14<br>Maven 4.4.4";
    }

    @GetMapping("/getAllUser")
    public List<EntiteAccount> getAllUser() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/getUserById")
    public EntiteAccount getUserById(@RequestParam("id") Integer id) {
        return accountService.getAccountById(id);
    }

    @GetMapping("/getUser")
    public EntiteAccount getUser(@RequestParam("email") String mail) {
        return accountService.getAccountByEmail(mail);
    }

    @GetMapping("getUserDtoById")
    public AccountDto getUserDtoById(@RequestParam("id") Integer id) {
        return accountService.getAccountDtoById(id);
    }

}


