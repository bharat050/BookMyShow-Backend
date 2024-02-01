package com.example.BMS.Repository;

import com.example.BMS.Model.TheatreSeats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatreSeatRepository extends JpaRepository<TheatreSeats, Integer> {
}
