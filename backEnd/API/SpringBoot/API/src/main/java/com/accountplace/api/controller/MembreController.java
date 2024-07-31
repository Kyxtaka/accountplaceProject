package com.accountplace.api.controller;

import com.accountplace.api.domains.EntiteMembre;
import com.accountplace.api.dto.MembreDto;
import com.accountplace.api.service.MembreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/membre")
public class MembreController {
    @Autowired
    private MembreService membreService;

    @GetMapping("/create")
    public EntiteMembre create(@RequestBody EntiteMembre membre) {
        EntiteMembre result =  null;
        try {
            result = membreService.createMembre(membre);
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return result;
    }

    @GetMapping("/all")
    public List<EntiteMembre> getAll() {
        List<EntiteMembre> result = null;
        try {
            result = membreService.getAllMembres();
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return result;
    }

    @GetMapping("/byAccountId")
    public List<EntiteMembre> getByAccountId(@RequestParam("accountId") Integer accountId) {
        List<EntiteMembre> result = null;
        try {
            result = membreService.getAllMembreByAccountId(accountId);
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return result;
    }

    @GetMapping("/byGroupId")
    public List<EntiteMembre> getByGroupId(@RequestParam("groupId") Integer groupId) {
        List<EntiteMembre> result = null;
        try {
            result = membreService.getAllMembreByGroupId(groupId);
        }
        catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return result;
    }

    @GetMapping("/byId")
    public EntiteMembre getById(@RequestParam("goupId") Integer goupId, @RequestParam("accountId") Integer accountId) {
        EntiteMembre result = null;
        try {
            result = membreService.getMembreById(goupId, accountId);
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return result;
    }

    @GetMapping("/dto")
    public MembreDto dto(@RequestParam("groupId") Integer groupId, @RequestParam("accountId") Integer accountId) {
        MembreDto result = null;
        try {
            result = membreService.getMembreDtoById(groupId, accountId);
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return result;
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("groupId") Integer groupId, @RequestParam("accountId") Integer accountId) {
        String result = null;
        try {
            result = membreService.deleteMembreById(groupId,accountId);
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return result;
    }



}
