package com.accountplace.api.controller.service;


import com.accountplace.api.domains.data.EntiteAccount;
import com.accountplace.api.domains.util.LoginForm;
import com.accountplace.api.dto.AccountDto;
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
    public AccountDto login(@RequestBody LoginForm login) {
        AccountDto result = null;
        Email tmpEmail = new Email(login.getIdentifier());
        boolean isEmail = tmpEmail.isValid();
        try {
            EntiteAccount foundAccount = null;
            if (isEmail) {
                foundAccount = accountService.getAccountByEmail(login.getIdentifier());
            } else {
                foundAccount = accountService.getAccountByUsername(login.getIdentifier());
            }
            boolean checking = foundAccount.getPassword().equals(login.getPassword());
            if (checking) {result = accountService.getAccountDtoById(foundAccount.getId());}
        } catch (Exception e) {
            ResponseEntity.status(500).body(e.getMessage());
        }
        return result;
    }
}
