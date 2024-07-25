package com.accountplace.api.domains;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "groupe")
@Getter
@Setter
@NoArgsConstructor
public class EntiteGroupe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "password", nullable = false)
    private String password;

}
