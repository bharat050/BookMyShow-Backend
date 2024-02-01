package com.example.BMS.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Shows {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate showDate;

    private LocalTime showTime;

    private double multiplier;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
    private List<Ticket> bookedTicketList;

    @ManyToOne
    @JoinColumn
    private Movie movie;

    @ManyToOne
    @JoinColumn
    private Theatre theatre;

    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
    private List<ShowSeats> showSeatsList;
}
