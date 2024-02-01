package com.example.BMS.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class TheatreRespDto {
    private int id;

    private String name;

    private String city;

    private String address;
}
