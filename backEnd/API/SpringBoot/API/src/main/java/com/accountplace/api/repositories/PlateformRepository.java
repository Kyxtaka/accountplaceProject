package com.accountplace.api.repositories;

import com.accountplace.api.domains.EntitePlateform;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlateformRepository extends JpaRepository<EntitePlateform, Integer> {
    @Query("SELECT P FROM EntitePlateform P WHERE P.nom LIKE %:word% OR P.url LIKE %:word% ")
    List<EntitePlateform> findBySearch(String word);

}
