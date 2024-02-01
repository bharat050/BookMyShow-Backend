package com.example.BMS.Controller;

import com.example.BMS.RequestDto.TheatreReqDto;
import com.example.BMS.ResponseDto.TheatreRespDto;
import com.example.BMS.Service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theatre")
public class TheatreController {

    @Autowired
    TheatreService theatreService;
    @PostMapping("/add_theatre")
    public ResponseEntity<String> addTheatre(@RequestBody()TheatreReqDto theatreReqDto){
        return new ResponseEntity<>(theatreService.addTheatre(theatreReqDto), HttpStatus.CREATED);
    }

    @GetMapping("/get_theatre_by_id/{id}")
    public ResponseEntity<TheatreRespDto> getTheatreById(@PathVariable("id") Integer id){
        return new ResponseEntity<>(theatreService.getTheatreById(id), HttpStatus.FOUND);
    }

    @GetMapping("/get_all_theatres/{movie}")
    public ResponseEntity<List<TheatreRespDto>> getAllTheatresByMovie(@PathVariable("movie") String movieName){
        return new ResponseEntity<>(theatreService.getAllTheatresByMovie(movieName), HttpStatus.FOUND);
    }
}
