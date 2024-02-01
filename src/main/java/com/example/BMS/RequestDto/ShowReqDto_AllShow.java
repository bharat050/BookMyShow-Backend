package com.example.BMS.RequestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.cglib.core.Local;

import java.time.LocalTime;
@Data
@AllArgsConstructor
public class ShowReqDto_AllShow {

    private LocalTime fromTime;

    private LocalTime toTime;

    private int movieId;
}
