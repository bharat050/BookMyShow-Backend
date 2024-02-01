package com.example.BMS.Controller;

import com.example.BMS.RequestDto.BookTicketDto;
import com.example.BMS.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ticket")
public class TicketController {

    @Autowired
    TicketService ticketService;
    @PostMapping("/book_ticket")
    public ResponseEntity<String> bookTicket(@RequestBody()BookTicketDto bookTicketDto){
        return new ResponseEntity<>(ticketService.bookTicket(bookTicketDto), HttpStatus.CREATED);
    }
}
