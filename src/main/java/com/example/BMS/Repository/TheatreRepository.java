package com.example.BMS.Repository;

import com.example.BMS.Model.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Integer> {

    List<Theatre> findAllByListOfShows_Movie_Name(String movieName);
}
