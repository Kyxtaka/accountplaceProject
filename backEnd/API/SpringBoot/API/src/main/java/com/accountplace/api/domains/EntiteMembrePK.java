package com.accountplace.api.domains;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@ToString
public class EntiteMembrePK implements Serializable {


    private Integer groupid;
    private Integer accountid;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntiteMembrePK that = (EntiteMembrePK) o;
        return Objects.equals(groupid, that.groupid) && Objects.equals(accountid, that.accountid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupid, accountid);
    }
}
