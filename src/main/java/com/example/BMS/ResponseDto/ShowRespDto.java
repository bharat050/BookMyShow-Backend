package com.example.BMS.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
@Data
@AllArgsConstructor
@Builder
public class ShowRespDto {

    private LocalDate showDate;

    private LocalTime showTime;

    private Date createdAt;

    private Date updatedAt;

    private String movieName;

    private String theatreName;
}
