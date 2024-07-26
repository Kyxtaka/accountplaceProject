package com.accountplace.api.repositories;

import com.accountplace.api.domains.EntiteCredential;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CredentialRepository {
    @Query("SELECT C FROM EntiteCredential C WHERE C.id = :id")
    EntiteCredential findCredentialById(@Param("id") int id);

    @Query("SELECT C FROM EntiteCredential C")
    List<EntiteCredential> findAll();

    @Query("SELECT C FROM EntiteCredential C WHERE C.groupid=:id")
    List<EntiteCredential> listCredentialByGroupId(@Param("id") int id);

    @Query("SELECT C FROM EntiteCredential C WHERE C.groupid=:gid AND C.plateformid = :pid")
    List<EntiteCredential> listCredentialByGroupAndPlateformId(@Param("gid") int gid, @Param("pid") int pid);
}
