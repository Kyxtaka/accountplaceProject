package com.accountplace.api.repositories;

import com.accountplace.api.domains.data.EntiteGroupe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<EntiteGroupe, Integer> {
    @Query("SELECT G FROM EntiteGroupe G WHERE G.nom LIKE %:nom% ")
    List<EntiteGroupe> findGroupByNom(@Param("nom") String nom);

}
