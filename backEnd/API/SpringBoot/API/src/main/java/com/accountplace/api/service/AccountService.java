package com.accountplace.api.service;

import com.accountplace.api.domains.EntiteAccount;
import com.accountplace.api.domains.EntiteGroupe;
import com.accountplace.api.domains.EntiteMembre;
import com.accountplace.api.dto.AccountDto;
import com.accountplace.api.dto.Email;
import com.accountplace.api.dto.GroupDto;
import com.accountplace.api.dto.Privilege;
import com.accountplace.api.repositories.AccountRepository;
import com.accountplace.api.repositories.GroupRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private MembreService membreService;
    @Autowired
    private GroupService groupService;

    public EntiteAccount createAccount(EntiteAccount entiteAccount) {
        return accountRepository.save(entiteAccount);
    }

    public List<EntiteAccount> getAllAccounts() {
        return accountRepository.findAll();
    }

    public EntiteAccount getAccountById(Integer id) {
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

    public EntiteAccount updateAccount(Integer id, EntiteAccount account) {
        return accountRepository.findById(id).map(account1 -> {
            account1.setUsername(account.getUsername());
            account1.setPassword(account.getPassword());
            account1.setEmail(account.getEmail());
            account1.setPrivileges(account.getPrivileges());
            return accountRepository.save(account1);
        }).orElseThrow(() -> new RuntimeException("Account not found with id " + id));
    }

    public String deleteAccountById(Integer id) {
        accountRepository.deleteById(id);
        return "Account with id " + id + " has been deleted successfully";
    }

    public AccountDto getAccountDtoById(Integer id) {
        EntiteAccount entiteAccount = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account not found with id " + id));
        return convertToDto(entiteAccount);
    }

    private AccountDto convertToDto(EntiteAccount entiteAccount) {
//      Privilege privilege = Privilege.valueOf(entiteAccount.getPrivileges());
        Email email =  new Email(entiteAccount.getEmail());
        List<GroupDto> groups = new ArrayList<>();
        for (EntiteMembre grp: membreService.getAllMembreByAccountId(entiteAccount.getId())) {
            groups.add(groupService.getGroupDtoById(grp.getGroupid().getId()));
        }
        return new AccountDto(
                entiteAccount.getId(),
                entiteAccount.getUsername(),
                email,
                entiteAccount.getPassword(),
                entiteAccount.getPrivileges(),
                groups
        );
    }

}
