package com.example.BMS.Repository;

import com.example.BMS.Model.ShowSeats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeats, Integer> {
}
