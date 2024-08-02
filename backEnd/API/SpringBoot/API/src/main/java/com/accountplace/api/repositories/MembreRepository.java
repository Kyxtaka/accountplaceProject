package com.accountplace.api.repositories;

import com.accountplace.api.domains.data.EntiteMembre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MembreRepository extends JpaRepository<EntiteMembre, Integer> {
    @Query("SELECT M FROM EntiteMembre M WHERE M.accountid.id=:aId")
    List<EntiteMembre> findByAccountId(@Param("aId") int aId);

    @Query("SELECT M FROM EntiteMembre M WHERE M.groupid.id=:gId")
    List<EntiteMembre> findByGroupId(@Param("gId") Integer gId);

    @Query("SELECT M FROM EntiteMembre M WHERE M.groupid.id=:gId AND M.accountid.id=:aId")
    EntiteMembre findByFullId(@Param("gId") Integer gId, @Param("aId") Integer aId);

    @Query("DELETE FROM EntiteMembre M WHERE M.groupid.id=:gId AND M.accountid.id=:aId")
    void deleteByFullId(@Param("gId") Integer gId, @Param("aId") Integer aId);

//    @Modifying
//    @Query("insert into membre M (groupeid, accountid) VALUES SELECT :gId,aId")
//    public void insert(@Param("gId") Integer gId, @Param("aId") Integer aId);
}
