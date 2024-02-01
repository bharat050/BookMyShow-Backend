package com.example.BMS.Controller;

import com.example.BMS.RequestDto.MovieReqDto;
import com.example.BMS.ResponseDto.MovieRespDto;
import com.example.BMS.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("movie")
public class MovieController {
    @Autowired
    MovieService movieService;
    @PostMapping("/add_movie")
    public ResponseEntity<String> addMovie(@RequestBody()MovieReqDto movieReqDto){
        String ans = movieService.addMovie(movieReqDto);
        return new ResponseEntity<>(ans, HttpStatus.CREATED);
    }

    @GetMapping("/get_movie_by_name/{name}")
    public ResponseEntity<MovieRespDto> getMovieByName(@PathVariable("name") String name){
        return new ResponseEntity<>(movieService.getMovieByName(name), HttpStatus.FOUND);
    }
}
