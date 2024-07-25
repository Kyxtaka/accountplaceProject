package com.accountplace.api.dto;

import lombok.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Setter
@Getter
@ToString
@AllArgsConstructor
@EqualsAndHashCode
public class EmailDto {
    String mailAddress;

    public boolean isValid() {
        Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
        Matcher m = p.matcher(this.mailAddress);
        return m.matches();
    }
}
