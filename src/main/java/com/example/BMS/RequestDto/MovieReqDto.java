package com.example.BMS.RequestDto;

import lombok.Data;

import java.util.Date;
@Data
public class MovieReqDto {
    private String name;

    private Date releaseDate;

    private int duration;
}
