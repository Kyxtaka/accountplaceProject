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
        List<EntiteAccount> result = null;
        try {
            result = accountService.getAllAccounts();
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return result;
    }

    @GetMapping("/getById")
    public EntiteAccount getUserById(@RequestParam("id") Integer id) {
        EntiteAccount result = null;
        try {
            result = accountService.getAccountById(id);
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return result;
    }

    @GetMapping("/getByEmail")
    public EntiteAccount getUser(@RequestParam("email") String mail) {
        EntiteAccount result = null;
        try {
            result = accountService.getAccountByEmail(mail);
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return result;
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
        EntiteAccount result = null;
        try {
            result = accountService.getAccountByUsername(username);
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return result;
    }
    @GetMapping("count")
    public Long getUserCount() {
        Long result = null;
        try {
            result = accountService.countAccount();
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return result;
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id) {
        String response = null;
        try {
            response = accountService.deleteAccountById(id);
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return response;
    }

}


