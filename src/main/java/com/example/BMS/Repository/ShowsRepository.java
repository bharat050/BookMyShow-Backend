package com.example.BMS.Repository;

import com.example.BMS.Model.Shows;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowsRepository extends JpaRepository<Shows, Integer> {
}
