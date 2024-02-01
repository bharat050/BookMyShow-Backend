package com.example.BMS.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovieRespDto {
    private int id;

    private String name;

    private Date releaseDate;

    private int duration;
}
