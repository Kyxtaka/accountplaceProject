package com.accountplace.api.domains;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "credential")
@Getter
@Setter
@NoArgsConstructor
public class EntiteCredential implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "mail")
    private String mail;

    @Column(name = "accountid")
    private String accountid;

    @Column(name = "password")
    private String password;

    @Column(name = "a2f")
    private int a2f;

    @Column(name = "plateformid", nullable = false)
    private String plateformid;

    @Column(name = "groupeid", nullable = false)
    private String groupid;

}
