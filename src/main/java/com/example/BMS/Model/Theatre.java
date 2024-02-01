package com.example.BMS.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Theatre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String city;

    private String address;

    @OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL)
    private List<Shows> listOfShows;

    @OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL)
    private List<TheatreSeats> theatreSeatsList;
}
