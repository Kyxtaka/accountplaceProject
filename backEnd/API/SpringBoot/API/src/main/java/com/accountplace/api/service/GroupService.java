package com.accountplace.api.service;

import com.accountplace.api.domains.EntiteGroupe;
import com.accountplace.api.dto.GroupDto;
import com.accountplace.api.repositories.GroupRepository;
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
        return groupRepository.findAllGroups();
    }

    public EntiteGroupe getGroupById(int id) {
        return groupRepository.findGroupById(id);
    }

    public EntiteGroupe updateGroup(long id,EntiteGroupe entiteGroupe) {
        return groupRepository.findById(id).map( groupe -> {
            groupe.setId(entiteGroupe.getId());
            groupe.setNom(entiteGroupe.getNom());
            groupe.setPassword(entiteGroupe.getPassword());
            return groupRepository.save(groupe);
        }).orElseThrow( () -> new RuntimeException("Group with " + id + " not found"));
    }

    public String deleteGroupById(long id) {
        groupRepository.deleteById(id);
        return "Group with " + id + " has been deleted successfully";
    }

    public GroupDto getGroupDtoById(int id) {
        EntiteGroupe entiteGroupe = groupRepository.findGroupById(id);
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
