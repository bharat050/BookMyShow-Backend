package com.example.BMS.RequestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShowsReqDto {
    private LocalDate showDate;
    private LocalTime showTime;
    private int movieId;
    private int theatreId;
    private double multiplier;
}
