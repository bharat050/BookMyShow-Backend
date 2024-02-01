package com.example.BMS.RequestDto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TheatreReqDto {
    private String name;

    private String city;

    private String address;
}
