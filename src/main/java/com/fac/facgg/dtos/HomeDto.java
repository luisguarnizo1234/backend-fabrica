package com.fac.facgg.dtos;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class HomeDto {

    private Double rxBytes;
    private Double txBytes;
    private Double rssi;
    private Double rfError;
    private Double backgroundRssi;
    private Double bostCount;
    private Double tempPa;
    private Double tempBrd;
    private Double cause;
    private Double lastContact;

}
