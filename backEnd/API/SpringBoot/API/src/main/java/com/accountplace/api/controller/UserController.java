package com.accountplace.api.controller;

import com.accountplace.api.domains.EntiteAccount;
import com.accountplace.api.dto.AccountDto;
import com.accountplace.api.service.AccountService;
import com.accountplace.api.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/infos")
    public String info() {
        return "PostgreSQL 14<br>Angular 17<br>Spring Boot 14<br>Maven 4.4.4";
    }

    @GetMapping("/all")
    public List<EntiteAccount> getAllUser() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/getById")
    public EntiteAccount getUserById(@RequestParam("id") Integer id) {
        return accountService.getAccountById(id);
    }

    @GetMapping("/getByEmail")
    public EntiteAccount getUser(@RequestParam("email") String mail) {
        return accountService.getAccountByEmail(mail);
    }

    @GetMapping("get/{id}")
    public AccountDto getUserDtoById(@PathVariable("id") Integer id) {
        AccountDto accountDto = null;
        try {
            accountDto = accountService.getAccountDtoById(id);
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return accountDto;
    }

    @GetMapping("/getByUsername")
    public EntiteAccount getUserByUsername(@RequestParam("username") String username) {
        return accountService.getAccountByUsername(username);
    }
    @GetMapping("count")
    public Long getUserCount() {
        return accountService.countAccount();
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id) {
        String response = null;
        response = accountService.deleteAccountById(id);
        return response;
    }

}


