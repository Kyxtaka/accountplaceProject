package com.accountplace.api.domains;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Entity
@Table(name = "plateform")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class EntitePlateform implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "url", nullable = false)
    private String url;

    @Column(name = "imgRef", nullable = true)
    private String imgRef;
}
