package com.accountplace.api.service;

import com.accountplace.api.domains.EntitePlateform;
import com.accountplace.api.repositories.PlateformRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PlateformService {

    @Autowired
    private PlateformRepository plateformRepository;

    public EntitePlateform createPlateform(EntitePlateform entitePlateform) {
        return plateformRepository.save(entitePlateform);
    }
}
