package com.example.BMS.Service;

import com.example.BMS.Convertors.MovieConvertor;
import com.example.BMS.Model.Movie;
import com.example.BMS.Model.User;
import com.example.BMS.Repository.MovieRepository;
import com.example.BMS.Repository.UserRepository;
import com.example.BMS.RequestDto.MovieReqDto;
import com.example.BMS.ResponseDto.MovieRespDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;
    public String addMovie(MovieReqDto movieReqDto){
        Movie movie = MovieConvertor.movieDtoToEntity(movieReqDto);
        movieRepository.save(movie);
        return "Movie Saved Successfully";
    }

    public MovieRespDto getMovieByName(String name){
        Movie movie = movieRepository.findByName(name);
        return MovieConvertor.movieEntityToDto(movie);
    }
}
