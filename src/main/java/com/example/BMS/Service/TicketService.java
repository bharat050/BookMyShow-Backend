package com.example.BMS.Service;

import com.example.BMS.Enum.SeatType;
import com.example.BMS.Model.ShowSeats;
import com.example.BMS.Model.Shows;
import com.example.BMS.Model.Ticket;
import com.example.BMS.Model.User;
import com.example.BMS.Repository.MovieRepository;
import com.example.BMS.Repository.ShowsRepository;
import com.example.BMS.Repository.TicketRepository;
import com.example.BMS.Repository.UserRepository;
import com.example.BMS.RequestDto.BookTicketDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TicketService {
    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ShowsRepository showsRepository;

    public String bookTicket(BookTicketDto bookTicketDto){
        User user = userRepository.findById(bookTicketDto.getUserId()).get();
        Shows shows = showsRepository.findById(bookTicketDto.getShowId()).get();
        Ticket ticket = Ticket.builder().
                        user(user).show(shows).build();

        List<ShowSeats> showSeatsList = shows.getShowSeatsList();

        List<ShowSeats> availableSeats = new ArrayList<>();
        // To check the availability of Seats.
        double amount = 0;
        StringBuilder allocatedSeats = new StringBuilder();

        List<String> requestedSeats = bookTicketDto.getRequestedSeats();

        for(ShowSeats seat: showSeatsList){
            if(requestedSeats.contains(seat.getSeatNo()) && !seat.isBooked()){
                seat.setBooked(true);
                seat.setBookedAt(new Date());
                seat.setTicket(ticket);
                int val = 0;
                if(seat.getSeatType().equals(SeatType.PREMIUM)) val = 200;
                else val = 100;
                availableSeats.add(seat);
                allocatedSeats.append(seat.getSeatNo()).append(" ");
                amount += val*shows.getMultiplier(); // amount is calculate over here for selected seats;
            }
        }
        ticket.setAllocateSeat(allocatedSeats.toString());
        ticket.setBookedAt(new Date());
        ticket.setShowSeatsList(availableSeats);
        ticket.setAmount(amount);
        user.getBookedTickets().add(ticket);
        shows.getBookedTicketList().add(ticket);

        ticketRepository.save(ticket);
//        showsRepository.save(shows);
//        userRepository.save(user);
        return "Ticket has been booked";
    }
}
