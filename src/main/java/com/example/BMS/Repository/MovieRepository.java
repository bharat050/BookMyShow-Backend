package com.example.BMS.Repository;

import com.example.BMS.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    public Movie findByName(String name);
}
