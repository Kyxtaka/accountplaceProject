package com.accountplace.api.service;

import com.accountplace.api.domains.EntiteCredential;
import com.accountplace.api.dto.CredentialDto;
import com.accountplace.api.dto.Email;
import com.accountplace.api.repositories.CredentialRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CredentialService {

    @Autowired
    private CredentialRepository credentialRepository;

    public EntiteCredential createCredential(EntiteCredential credential) {
        return credentialRepository.save(credential);
    }

    public List<EntiteCredential> getAllCredentials() {
        return credentialRepository.findAll();
    }

    public EntiteCredential getCredentialById(int id) {
        return credentialRepository.findById(id).orElseThrow( () -> new RuntimeException("Credential not found"));
    }

    public List<EntiteCredential> getAllCredentialByGroupId(int groupId) {
        return credentialRepository.listCredentialByGroupId(groupId);
    }

    public List<EntiteCredential> getAllCredentialByGroupAndPlateformId(int groupId, int plateformId) {
        return credentialRepository.listCredentialByGroupAndPlateformId(groupId, plateformId);
    }

    public List<EntiteCredential> getAllCredentialByEmail(Email mail) {
        return credentialRepository.listCredentialByMail(mail.getMailAddress());
    }

    public EntiteCredential updateCredential(int id,EntiteCredential entiteCredential) {
        return credentialRepository.findById(id).map( credential -> {
           credential.setAccountid(entiteCredential.getAccountid());
           credential.setMail(entiteCredential.getMail());
           credential.setPassword(entiteCredential.getPassword());
           credential.setA2f(entiteCredential.getA2f());
           credential.setPlateformid(entiteCredential.getPlateformid());
           return credentialRepository.save(credential);
        }).orElseThrow(() -> new RuntimeException("Credential not found"));
    }

    public String deleteCredentialById(int id) {
        credentialRepository.deleteById(id);
        return "Credential deleted with id: " + id + " has been deleted successfully";
    }

    public CredentialDto getCredentialDtoById(int id) {
        EntiteCredential entiteCredential = credentialRepository.findById(id).orElseThrow(() -> new RuntimeException("Credential not found"));
        return convertToDto(entiteCredential);
    }

    private CredentialDto convertToDto(EntiteCredential credential) {
        boolean a2f = credential.getA2f() == 1;
        Email mail = new Email(credential.getMail());
        return new CredentialDto(
                credential.getId(),
                credential.getAccountid(),
                credential.getPassword(),
                mail,
                a2f,
                credential.getPlateformid(),
                credential.getGroupid()
        );
    }
}
