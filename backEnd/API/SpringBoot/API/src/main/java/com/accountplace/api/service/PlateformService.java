package com.accountplace.api.service;

import com.accountplace.api.domains.EntiteAccount;
import com.accountplace.api.domains.EntitePlateform;
import com.accountplace.api.dto.PlateformDto;
import com.accountplace.api.repositories.PlateformRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PlateformService {

    @Autowired
    private PlateformRepository plateformRepository;

    public EntitePlateform createPlateform(EntitePlateform entitePlateform) {
        return plateformRepository.save(entitePlateform);
    }

    public EntitePlateform getPlateformById(Integer id) {
        return plateformRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public List<EntitePlateform> getAllPlateforms() {
        return plateformRepository.findAll();
    }
    public List<EntitePlateform> getPlateformByName(String name) {
        return plateformRepository.findBySearch(name);
    }

    public EntitePlateform updatePlateform(Integer id,EntitePlateform entitePlateform) {
        return plateformRepository.findById(id).map( plateform1 -> {
            plateform1.setNom(entitePlateform.getNom());
            plateform1.setUrl(entitePlateform.getUrl());
            plateform1.setImgRef(entitePlateform.getImgRef());
            return plateformRepository.save(plateform1);
        }).orElseThrow( () -> new RuntimeException("Plateform with " + id + " not found") );
    }

    public String deletePlateform(Integer id) {
        plateformRepository.deleteById(id);
        return "Plateform with id " + id + " has been deleted successfully";
    }

    public PlateformDto getPlateformDtoById(Integer id) {
        EntitePlateform entitePlateform = plateformRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return convertToDto(entitePlateform);
    }

    private PlateformDto convertToDto(EntitePlateform entitePlateform) {
        return new PlateformDto(
          entitePlateform.getId(),
          entitePlateform.getNom(),
          entitePlateform.getUrl(),
        entitePlateform.getImgRef()
        );
    }
}
