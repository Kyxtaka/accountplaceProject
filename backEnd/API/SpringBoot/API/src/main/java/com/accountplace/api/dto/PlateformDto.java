package com.accountplace.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PlateformDto {
    private int plateformId;
    private String plateformName;
    private String url;
    private String imgRef;
}
