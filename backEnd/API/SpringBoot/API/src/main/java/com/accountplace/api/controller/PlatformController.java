package com.accountplace.api.controller;


import com.accountplace.api.domains.EntitePlateform;
import com.accountplace.api.dto.PlateformDto;
import com.accountplace.api.service.PlateformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/platform")
public class PlatformController {

    @Autowired
    private PlateformService plateformService;

    @GetMapping("/create")
    public EntitePlateform create(@RequestBody EntitePlateform entitePlateform) {
        EntitePlateform result = null;
        try {
            result = plateformService.createPlateform(entitePlateform);
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return result;
    }

    @GetMapping("/update")
    public EntitePlateform update(@RequestParam("id") Integer id, @RequestBody EntitePlateform entitePlateform) {
        EntitePlateform result = null;
        try {
            result = plateformService.updatePlateform(id, entitePlateform);
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return result;
    }

    @GetMapping("/byId")
    public EntitePlateform byId(@RequestParam("id") Integer id) {
        EntitePlateform result = null;
        try {
            result = plateformService.getPlateformById(id);
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return result;
    }

    @GetMapping("/all")
    public List<EntitePlateform> getAll() {
        List<EntitePlateform> result = null;
        try {
            result = plateformService.getAllPlateforms();
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return result;
    }

    @GetMapping("/search")
    public List<EntitePlateform> search(@RequestParam("name") String name) {
        List<EntitePlateform> result = null;
        try {
            result = plateformService.getPlateformByName(name);
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return result;
    }

    @GetMapping("/dto")
    public PlateformDto dto(@RequestParam("id") Integer id) {
        PlateformDto result = null;
        try {
            result = plateformService.getPlateformDtoById(id);
        } catch (Exception e){
            ResponseEntity.notFound().build();
        }
        return result;
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Integer id) {
        String result = null;
        try {
            result = plateformService.deletePlateform(id);
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return result;
    }

}
