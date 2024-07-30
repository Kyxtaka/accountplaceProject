package com.accountplace.api.controller;

import com.accountplace.api.domains.EntiteCredential;
import com.accountplace.api.dto.CredentialDto;
import com.accountplace.api.dto.Email;
import com.accountplace.api.service.CredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("credential")
public class CredentialController {

    @Autowired
    private CredentialService credentialService;

    @GetMapping("/all")
    public List<EntiteCredential> getAllCredentials() {
        List<EntiteCredential> credentials = null;
        try {
            credentials = credentialService.getAllCredentials();
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return credentials;
    }

    @GetMapping("/ById")
    public EntiteCredential getCredentialById(@RequestParam("id") Integer id) {
        EntiteCredential credential = null;
        try {
            credential = credentialService.getCredentialById(id);
        }
        catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return credential;
    }

    @GetMapping("/byGroup")
    public List<EntiteCredential> getCredentialByGroupId(@RequestParam("groupId") Integer groupId) {
        List<EntiteCredential> credentials = null;
        try {
            credentials = credentialService.getAllCredentialByGroupId(groupId);
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return credentials;
    }

    @GetMapping("/groupIdAndPlatformId")
    public List<EntiteCredential> getCredentialByGroupAndPlatformId(@RequestParam("groupId") Integer groupId, @RequestParam("platformId") Integer platformId) {
        List<EntiteCredential> credentials = null;
        try {
            credentials = credentialService.getAllCredentialByGroupAndPlateformId(groupId, platformId);
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return credentials;
    }

    @GetMapping("/ByEmail")
    public List<EntiteCredential> getCredentialByEmail(@RequestParam("email") String email) {
        List<EntiteCredential> credentials = null;
        Email mail = new Email(email);
        System.out.println(mail.isValid());
        System.out.println(mail.getMailAddress());
        if (!mail.isValid()) return null;
        try {
            credentials = credentialService.getAllCredentialByEmail(mail);
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return credentials;
    }

    @GetMapping("/create")
    public EntiteCredential createCredential(@RequestBody EntiteCredential credential) {
        EntiteCredential credentials = null;
        try {
            credentials = credentialService.createCredential(credential);
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return credentials;
    }

    @GetMapping("/delete")
    public String deleteCredential(@RequestParam("id") int id) {
        String credential = null;
        try {
            credential = credentialService.deleteCredentialById(id);
        }catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return credential;
    }

    @GetMapping("/dto")
    public CredentialDto getCredentialDto(@RequestParam("id") int id) {
        CredentialDto credentialDto = null;
        try {
            credentialDto = credentialService.getCredentialDtoById(id);
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return credentialDto;
    }

    @GetMapping("/update")
    public EntiteCredential updateCredential(@RequestParam("id") Integer id,@RequestBody EntiteCredential credential) {
        EntiteCredential credentials = null;
        try {
            credentials = credentialService.updateCredential(id, credential);
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return credentials;
    }

}
