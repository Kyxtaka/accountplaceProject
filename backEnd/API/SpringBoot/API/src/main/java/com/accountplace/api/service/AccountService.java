package com.accountplace.api.service;

import com.accountplace.api.domains.EntiteAccount;
import com.accountplace.api.dto.AccountDto;
import com.accountplace.api.dto.Email;
import com.accountplace.api.dto.Privilege;
import com.accountplace.api.repositories.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class AccountService {

    private AccountRepository anAccountRepository;

    public EntiteAccount createAccount(EntiteAccount entiteAccount) {
        return anAccountRepository.save(entiteAccount);
    }

    public List<EntiteAccount> getAllAccounts() {
        return anAccountRepository.findAllAccounts();
    }

    public EntiteAccount getAccountById(int id) {
        return anAccountRepository.findAccountById(id);
    }

    public EntiteAccount getAccountByEmail(String email) {
        return anAccountRepository.findAccountByEmail(email);
    }

    public EntiteAccount getAccountByUsername(String username) {
        return anAccountRepository.findAccountByUsername(username);
    }

    public long countAccount() {
        return anAccountRepository.count();
    }

    public EntiteAccount updateAccount(Integer Id, EntiteAccount account) {
        return anAccountRepository.findById(Id).map(account1 -> {
            account1.setUsername(account.getUsername());
            account1.setPassword(account.getPassword());
            account1.setEmail(account.getEmail());
            account1.setPrivileges(account.getPrivileges());
            return anAccountRepository.save(account1);
        }).orElseThrow(() -> new RuntimeException("Account not found with id " + Id));
    }

    public String deleteAccountById(int id) {
        anAccountRepository.deleteById(id);
        return "Account with id " + id + " has been deleted successfully";
    }

    public AccountDto getAccountDtoById(Integer id) {
        EntiteAccount entiteAccount = anAccountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account not found with id " + id));
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
