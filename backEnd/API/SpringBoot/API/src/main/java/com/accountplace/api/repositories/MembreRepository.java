package com.accountplace.api.repositories;

import com.accountplace.api.domains.EntiteMembre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MembreRepository extends JpaRepository<EntiteMembre, Integer> {
    @Query("SELECT M FROM EntiteMembre M")
    List<EntiteMembre> findAllMembre();

    @Query("SELECT M FROM EntiteMembre M WHERE M.accountid=:aId")
    List<EntiteMembre> findByAccountId(@Param("aId") int aId);

    @Query("SELECT M FROM EntiteMembre M WHERE M.groupid=:gId")
    List<EntiteMembre> findByGroupId(@Param("gId") int gId);

    @Query("SELECT M FROM EntiteMembre M WHERE M.groupid=:gId AND M.accountid=:aId")
    EntiteMembre findByFullId(@Param("gId") int gId, @Param("aId") int aId);
}
