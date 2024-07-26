package com.accountplace.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.accountplace.api.domains.EntiteAccount;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<EntiteAccount, Integer> {
    @Query("SELECT A FROM EntiteAccount A")
    List<EntiteAccount> findAllAccounts();

    @Query("SELECT A FROM EntiteAccount A WHERE A.id=:id")
    EntiteAccount findAccountById(@Param("id") Integer id);

    @Query("SELECT A FROM EntiteAccount A WHERE A.email=:email")
    EntiteAccount findAccountByEmail(String email);

    @Query("SELECT A FROM EntiteAccount A WHERE A.username=:username")
    EntiteAccount findAccountByUsername(String username);
}
