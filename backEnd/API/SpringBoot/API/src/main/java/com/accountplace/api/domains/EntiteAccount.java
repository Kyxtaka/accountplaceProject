package com.accountplace.api.domains;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "account")
public class EntiteAccount implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "mail", nullable = false, unique = true)
    private String email;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "privilege")
    private String privileges;


}
