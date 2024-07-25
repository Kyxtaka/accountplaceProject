package com.accountplace.api.domains;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
public class EntiteMembrePK implements Serializable {

    private Integer groupe;
    private Integer account;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntiteMembrePK that = (EntiteMembrePK) o;
        return Objects.equals(groupe, that.groupe) && Objects.equals(account, that.account);
    }

    @Override
    public int hashCode() {
        return Objects.hash(account, account);
    }
}
