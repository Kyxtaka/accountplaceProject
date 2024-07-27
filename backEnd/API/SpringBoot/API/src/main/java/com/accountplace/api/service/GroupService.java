package com.accountplace.api.service;

import com.accountplace.api.domains.EntiteGroupe;
import com.accountplace.api.dto.GroupDto;
import com.accountplace.api.repositories.GroupRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    public EntiteGroupe createGroup(EntiteGroupe entiteGroupe) {
        return groupRepository.save(entiteGroupe);
    }

    public List<EntiteGroupe> listGroups() {
        return groupRepository.findAll();
    }

    public EntiteGroupe getGroupById(Integer id) {
        return groupRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public List<EntiteGroupe> listGroupByName(String name) {
        return groupRepository.findGroupByNom(name);
    }

    public EntiteGroupe updateGroup(Integer id,EntiteGroupe entiteGroupe) {
        return groupRepository.findById(id).map( groupe -> {
            groupe.setNom(entiteGroupe.getNom());
            groupe.setPassword(entiteGroupe.getPassword());
            return groupRepository.save(groupe);
        }).orElseThrow( () -> new RuntimeException("Group with " + id + " not found"));
    }

    public String deleteGroupById(Integer id) {
        groupRepository.deleteById(id);
        return "Group with " + id + " has been deleted successfully";
    }

    public GroupDto getGroupDtoById(Integer id) {
        EntiteGroupe entiteGroupe = groupRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return convertToDto(entiteGroupe);
    }

    private GroupDto convertToDto(EntiteGroupe entiteGroupe) {
        return new GroupDto(
                entiteGroupe.getId(),
                entiteGroupe.getNom(),
                "no description",
                entiteGroupe.getPassword()
        );
    }
}
