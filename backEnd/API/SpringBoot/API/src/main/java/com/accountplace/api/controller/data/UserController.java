package com.accountplace.api.controller.data;

import com.accountplace.api.domains.data.EntiteAccount;
import com.accountplace.api.dto.AccountDto;
import com.accountplace.api.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/api/data/user")
public class UserController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/infos")
    public String info() {
        return "RestController for User Account of this application";
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

    @GetMapping("/byId")
    public EntiteAccount getUserById(@RequestParam("id") Integer id) {
        EntiteAccount result = null;
        try {
            result = accountService.getAccountById(id);
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return result;
    }

    @GetMapping("/byEmail")
    public EntiteAccount getUser(@RequestParam("email") String mail) {
        EntiteAccount result = null;
        try {
            result = accountService.getAccountByEmail(mail);
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return result;
    }

    @GetMapping("/dto/{id}")
    public AccountDto getUserDtoById(@PathVariable("id") Integer id) {
        AccountDto accountDto = null;
        try {
            accountDto = accountService.getAccountDtoById(id);
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return accountDto;
    }

    @GetMapping("/byUsername")
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

    @GetMapping("create")
    public EntiteAccount createAccount(@RequestBody EntiteAccount entiteAccount) {
        EntiteAccount result = null;
        try {
            result = accountService.createAccount(entiteAccount);
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

    @GetMapping("/update")
    public EntiteAccount updateUser(@RequestParam("id") int id,@RequestBody EntiteAccount entiteAccount) {
        EntiteAccount response = null;
        try {
            response = accountService.updateAccount(id, entiteAccount);
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return response;
    }

}


