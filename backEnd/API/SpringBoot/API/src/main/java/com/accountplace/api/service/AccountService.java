package com.accountplace.api.service;

import com.accountplace.api.domains.EntiteAccount;
import com.accountplace.api.dto.AccountDto;
import com.accountplace.api.dto.Email;
import com.accountplace.api.dto.Privilege;
import com.accountplace.api.repositories.AccountRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class AccountService {

    private AccountRepository accountRepository;

    public EntiteAccount createAccount(EntiteAccount entiteAccount) {
        return accountRepository.save(entiteAccount);
    }

    public List<EntiteAccount> getAllAccounts() {
        return accountRepository.findAll();
    }

    public EntiteAccount getAccountById(int id) {
        return accountRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public EntiteAccount getAccountByEmail(String email) {
        return accountRepository.findAccountByEmail(email);
    }

    public EntiteAccount getAccountByUsername(String username) {
        return accountRepository.findAccountByUsername(username);
    }

    public long countAccount() {
        return accountRepository.count();
    }

    public EntiteAccount updateAccount(int id, EntiteAccount account) {
        return accountRepository.findById(id).map(account1 -> {
            account1.setUsername(account.getUsername());
            account1.setPassword(account.getPassword());
            account1.setEmail(account.getEmail());
            account1.setPrivileges(account.getPrivileges());
            return accountRepository.save(account1);
        }).orElseThrow(() -> new RuntimeException("Account not found with id " + id));
    }

    public String deleteAccountById(int id) {
        accountRepository.deleteById(id);
        return "Account with id " + id + " has been deleted successfully";
    }

    public AccountDto getAccountDtoById(int id) {
        EntiteAccount entiteAccount = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account not found with id " + id));
        return convertToDto(entiteAccount);
    }

    private AccountDto convertToDto(EntiteAccount entiteAccount) {
        Privilege privilege = Privilege.valueOf(entiteAccount.getPrivileges());
        Email email =  new Email(entiteAccount.getEmail());
        return new AccountDto(
                entiteAccount.getId(),
                entiteAccount.getUsername(),
                email,
                entiteAccount.getPassword(),
                privilege,
                new ArrayList<>()
        );
    }

}
