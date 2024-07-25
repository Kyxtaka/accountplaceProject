package com.accountplace.api.domains;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "membre")
@IdClass(EntiteMembrePK.class)
@Getter
@Setter
@NoArgsConstructor
public class EntiteMembre implements Serializable {
    @Id
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "groupid", nullable = false)
    private EntiteGroupe group;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accountid", nullable = false)
    private EntiteAccount account;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntiteMembre that = (EntiteMembre) o;
        return Objects.equals(group, that.group) && Objects.equals(account, that.account);
    }

    @Override
    public int hashCode() {
        return Objects.hash(group, account);
    }
}
