package com.example.BMS.Service;

import com.example.BMS.Model.*;
import com.example.BMS.Repository.MovieRepository;
import com.example.BMS.Repository.ShowSeatRepository;
import com.example.BMS.Repository.ShowsRepository;
import com.example.BMS.Repository.TheatreRepository;
import com.example.BMS.RequestDto.ShowReqDto_AllShow;
import com.example.BMS.RequestDto.ShowsReqDto;
import com.example.BMS.ResponseDto.ShowRespDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShowsService {
    @Autowired
    ShowsRepository showsRepository;
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    TheatreRepository theatreRepository;
    @Autowired
    ShowSeatRepository showSeatRepository;
    public String addShows(ShowsReqDto showsReqDto){
        Shows shows = Shows.builder().
                showDate(showsReqDto.getShowDate()).
                showTime(showsReqDto.getShowTime()).
                multiplier(showsReqDto.getMultiplier()).build();

        Movie movie = movieRepository.findById(showsReqDto.getMovieId()).get();

        Theatre theatre = theatreRepository.findById(showsReqDto.getTheatreId()).get();

        shows.setMovie(movie);
        shows.setTheatre(theatre);

        List<ShowSeats> showSeatsList = addShowSeatList(theatre.getTheatreSeatsList());
        shows.setShowSeatsList(showSeatsList);

        movie.getNoOfShows().add(shows);
        theatre.getListOfShows().add(shows);
//        System.out.println(showSeatsList.toString());
        for(ShowSeats seat: showSeatsList){
            seat.setShow(shows);
        }

        movieRepository.save(movie);
        theatreRepository.save(theatre);
        return "Shows been saved along with MovieId and TheatreId";
    }

    public List<ShowSeats> addShowSeatList(List<TheatreSeats> theatreSeatsList){
        List<ShowSeats> list = new ArrayList<>();

        for(TheatreSeats theatreSeats: theatreSeatsList){
            ShowSeats seat = ShowSeats.builder().
                    seatNo(theatreSeats.getSeatNo()).seatType(theatreSeats.getSeatType()).build();

            list.add(seat);
        }

        showSeatRepository.saveAll(list);
//        System.out.println("Reached upto here");
        return list;
    }

    public List<ShowRespDto> getAllShows(ShowReqDto_AllShow showReqDtoAllShow) {

        Movie movie = movieRepository.findById(showReqDtoAllShow.getMovieId()).get();
        List<Shows> showsList = showsRepository.findAll();

        LocalTime toTime = showReqDtoAllShow.getToTime();
        LocalTime fromTime = showReqDtoAllShow.getFromTime();

        List<ShowRespDto> ansList = new ArrayList<>();

        for(Shows show: showsList){
            LocalTime showTime = show.getShowTime();
            if(show.getMovie().equals(movie) && showTime.compareTo(fromTime) >= 0 && showTime.compareTo(toTime) <=0){
                ShowRespDto showRespDto = ShowRespDto.builder()
                                            .showDate(show.getShowDate())
                                            .showTime(show.getShowTime())
                                            .createdAt(show.getCreatedAt()).updatedAt(show.getUpdatedAt())
                                            .movieName(movie.getName())
                                            .theatreName(show.getTheatre().getName()).build();
                ansList.add(showRespDto);
            }
        }

        return ansList;
    }
}
