package com.accountplace.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class PlateformDto {
    private int plateformId;
    private String plateformName;
    private String url;
    private String imgRef;
}
