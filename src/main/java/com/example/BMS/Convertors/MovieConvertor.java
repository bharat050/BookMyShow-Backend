package com.example.BMS.Convertors;

import com.example.BMS.Model.Movie;
import com.example.BMS.RequestDto.MovieReqDto;
import com.example.BMS.ResponseDto.MovieRespDto;

public class MovieConvertor {

    public static Movie movieDtoToEntity(MovieReqDto movieReqDto){
        return Movie.builder().
                name(movieReqDto.getName()).
                releaseDate(movieReqDto.getReleaseDate()).
                duration(movieReqDto.getDuration()).
                build();
    }

    public static MovieRespDto movieEntityToDto(Movie movie){
        return MovieRespDto.builder().
                id(movie.getId()).name(movie.getName()).duration(movie.getDuration()).
                releaseDate(movie.getReleaseDate()).build();
    }
}
