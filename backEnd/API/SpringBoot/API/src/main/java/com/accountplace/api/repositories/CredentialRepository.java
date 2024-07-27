package com.accountplace.api.repositories;

import com.accountplace.api.domains.EntiteCredential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CredentialRepository  extends JpaRepository<EntiteCredential, Integer> {
    @Query("SELECT C FROM EntiteCredential C WHERE C.groupid=:id")
    List<EntiteCredential> listCredentialByGroupId(@Param("id") Integer id);

    @Query("SELECT C FROM EntiteCredential C WHERE C.groupid=:gid AND C.plateformid = :pid")
    List<EntiteCredential> listCredentialByGroupAndPlateformId(@Param("gid") Integer gid, @Param("pid") Integer pid);

    @Query("SELECT C FROM EntiteCredential C WHERE C.mail LIKE('%:mail%')")
    List<EntiteCredential> listCredentialByMail(@Param("mail") String mail);
}
