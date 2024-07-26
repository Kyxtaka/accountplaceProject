package com.accountplace.api.repositories;

import com.accountplace.api.domains.EntiteGroupe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<EntiteGroupe, Long> {
    @Query("SELECT G FROM EntiteGroupe G")
    List<EntiteGroupe> findAllGroups();

    @Query("SELECT G FROM EntiteGroupe G WHERE G.id=:id")
    EntiteGroupe findGroupById(@Param("id") int id);

}
