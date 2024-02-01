package com.example.BMS.Convertors;

import com.example.BMS.Model.Theatre;
import com.example.BMS.RequestDto.TheatreReqDto;
import com.example.BMS.ResponseDto.TheatreRespDto;

public class TheatreConvertor {

    public static Theatre theatreDtoTOEntity(TheatreReqDto theatreReqDto){
        return Theatre.builder().
                name(theatreReqDto.getName()).
                city(theatreReqDto.getCity()).
                address(theatreReqDto.getAddress()).build();
    }

    public static TheatreRespDto theatreEntityToDto(Theatre theatre){
        return TheatreRespDto.builder().
                id(theatre.getId()).name(theatre.getName()).
                address(theatre.getAddress()).city(theatre.getCity())
                .build();
    }
}
