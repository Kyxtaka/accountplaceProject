package com.accountplace.api.service;

import com.accountplace.api.domains.data.EntiteMembre;
import com.accountplace.api.dto.MembreDto;
import com.accountplace.api.repositories.MembreRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor
public class MembreService {

    @Autowired
    private MembreRepository membreRepository;

    public EntiteMembre createMembre(EntiteMembre membre) {
        return membreRepository.save(membre);
    }


    public List<MembreDto> getAllMembres() {
        List<MembreDto> result = new ArrayList<>();
        for (EntiteMembre membre : membreRepository.findAll()) {
            result.add(this.convertToDto(membre));
        }
        return result;
    }

    public List<MembreDto> getAllMembreByAccountId(Integer id) {
        List<MembreDto> result = new ArrayList<>();
        for (EntiteMembre membre : membreRepository.findByAccountId(id)) {
            result.add(this.convertToDto(membre));
        }
        return result;
    }

    public List<EntiteMembre> getAllEntiteMembreByAccountId(Integer id) {
        return membreRepository.findByAccountId(id);
    }

    public List<MembreDto> getAllMembreByGroupId(Integer id) {
        List<MembreDto> result = new ArrayList<>();
        for (EntiteMembre membre : membreRepository.findByGroupId(id)) {
            result.add(this.convertToDto(membre));
        }
        return result;
    }

//    public EntiteMembre getMembreById(Integer groupId, Integer accountId) {
//        return membreRepository.findByFullId(groupId, accountId);
//    }

//    public MembreDto getMembreDto(EntiteMembre membre) {
    //        return convertToDto(membre);
    //    }

    public String deleteMembreById(Integer groupId, Integer accountId) {
        membreRepository.deleteByFullId(groupId,accountId);
        return "Membre with id " + "("+groupId+","+accountId+")"+  " has been deleted successfully";
    }

    public MembreDto getMembreDtoById(Integer groupId, Integer accountId) {
        EntiteMembre membre = membreRepository.findByFullId(groupId, accountId);
        return convertToDto(membre);

    }

    private MembreDto convertToDto(EntiteMembre membre) {
        return new MembreDto(membre.getGroupid().getId(), membre.getAccountid().getId());
    }
}

