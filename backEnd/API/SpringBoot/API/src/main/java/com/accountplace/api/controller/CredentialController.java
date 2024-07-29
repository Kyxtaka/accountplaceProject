package com.accountplace.api.controller;

import com.accountplace.api.domains.EntiteCredential;
import com.accountplace.api.service.CredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
