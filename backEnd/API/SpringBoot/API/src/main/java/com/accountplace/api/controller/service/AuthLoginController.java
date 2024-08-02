package com.accountplace.api.controller.service;


import com.accountplace.api.domains.data.EntiteAccount;
import com.accountplace.api.domains.util.LoginForm;
import com.accountplace.api.dto.Email;
import com.accountplace.api.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/service/auth")
public class AuthLoginController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/login")
    public boolean login(@RequestBody LoginForm login) {
        boolean result = false;
        Email tmpEmail = new Email(login.getIdentifier());
        boolean isEmail = tmpEmail.isValid();
        try {
            EntiteAccount foundAccount = null;
            if (isEmail) {
                foundAccount = accountService.getAccountByEmail(login.getIdentifier());
            } else {
                foundAccount = accountService.getAccountByUsername(login.getIdentifier());
            }
            result = foundAccount.getPassword().equals(login.getPassword());
        } catch (Exception e) {
            ResponseEntity.status(500).body(e.getMessage());
        }
        return result;
    }
}
