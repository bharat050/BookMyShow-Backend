package com.example.BMS.Service;

import com.example.BMS.Convertors.TheatreConvertor;
import com.example.BMS.Enum.SeatType;
import com.example.BMS.Model.Theatre;
import com.example.BMS.Model.TheatreSeats;
import com.example.BMS.Repository.TheatreRepository;
import com.example.BMS.Repository.TheatreSeatRepository;
import com.example.BMS.RequestDto.TheatreReqDto;
import com.example.BMS.ResponseDto.TheatreRespDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheatreService {

    @Autowired
    TheatreRepository theatreRepository;
    @Autowired
    TheatreSeatRepository theatreSeatRepository;
    public String addTheatre(TheatreReqDto theatreReqDto){
        Theatre theatre = TheatreConvertor.theatreDtoTOEntity(theatreReqDto);

        List<TheatreSeats> list = addTheatreSeats();
        for(TheatreSeats seat : list){
            seat.setTheatre(theatre);
        }
        theatre.setTheatreSeatsList(list);
        theatreRepository.save(theatre);
        return "Theatre Added Successfully";
    }

    private List<TheatreSeats> addTheatreSeats(){
        List<TheatreSeats> seatsList = new ArrayList<>();
        int val = 'A';
        for(int i=0;i<5;i++){
            TheatreSeats seat = TheatreSeats.builder().
                    seatNo("1"+(char)(val+i)).
                    seatType(SeatType.CLASSIC).
                    rate(100).build();
            seatsList.add(seat);
        }
        for(int i=0;i<5;i++){
            TheatreSeats seat = TheatreSeats.builder().
                    seatNo("2"+(char)(val+i)).
                    seatType(SeatType.PREMIUM).
                    rate(200).build();
            seatsList.add(seat);
        }
        theatreSeatRepository.saveAll(seatsList);
        return seatsList;
    }

    public TheatreRespDto getTheatreById(Integer id){
        Theatre theatre = theatreRepository.findById(id).get();
        return TheatreConvertor.theatreEntityToDto(theatre);
    }

    public List<TheatreRespDto> getAllTheatresByMovie(String movieName){
        List<Theatre> theatresList = theatreRepository.findAllByListOfShows_Movie_Name(movieName);
        List<TheatreRespDto> ans = new ArrayList<>();

        for(Theatre theatre: theatresList){
            ans.add(TheatreConvertor.theatreEntityToDto(theatre));
        }
        return  ans;
    }
}
