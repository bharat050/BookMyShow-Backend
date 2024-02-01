package com.example.BMS.RequestDto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class BookTicketDto {

    private int userId;

    private int showId;

    private List<String> requestedSeats;
}
