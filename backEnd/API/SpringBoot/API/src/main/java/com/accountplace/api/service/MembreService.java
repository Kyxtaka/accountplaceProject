package com.accountplace.api.service;

import com.accountplace.api.domains.EntiteMembre;
import com.accountplace.api.dto.MembreDto;
import com.accountplace.api.repositories.MembreRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@AllArgsConstructor
public class MembreService {

    @Autowired
    private MembreRepository membreRepository;

    public EntiteMembre createMembre(EntiteMembre membre) {
        return membreRepository.save(membre);
    }

    public List<EntiteMembre> getAllMembres() {
        return membreRepository.findAll();
    }

    public List<EntiteMembre> getAllMembreByAccountId(int id) {
        return membreRepository.findByAccountId(id);
    }

    public List<EntiteMembre> getAllMembreByGroupId(int id) {
        return membreRepository.findByGroupId(id);
    }

    public EntiteMembre getMembreById(int groupId, int accountId) {
        return membreRepository.findByFullId(groupId, accountId);
    }
    public String deleteMembreById(int Id) {
        membreRepository.deleteById(Id);
        return "Membre with id " + Id + " has been deleted successfully";
    }
    public MembreDto getMembreDtoById(int groupId, int accountId) {
        EntiteMembre membre = membreRepository.findByFullId(groupId, accountId);
        return convertToDto(membre);
    }
    public MembreDto getMembreDto(EntiteMembre membre) {
        return convertToDto(membre);
    }
    private MembreDto convertToDto(EntiteMembre membre) {
        return new MembreDto(membre.getGroupid().getId(), membre.getAccountid().getId());
    }
}

