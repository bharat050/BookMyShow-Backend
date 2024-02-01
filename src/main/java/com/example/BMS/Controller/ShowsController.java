package com.example.BMS.Controller;

import com.example.BMS.RequestDto.ShowReqDto_AllShow;
import com.example.BMS.RequestDto.ShowsReqDto;
import com.example.BMS.ResponseDto.ShowRespDto;
import com.example.BMS.Service.ShowsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("shows")
public class ShowsController {

    @Autowired
    ShowsService showsService;
    @PostMapping("/add_shows")
    public ResponseEntity<String> addShows(@RequestBody()ShowsReqDto showsReqDto){
        return new ResponseEntity<>(showsService.addShows(showsReqDto), HttpStatus.CREATED);
    }

    @GetMapping("/get_all_shows")
    public List<ShowRespDto> getAllShows(@RequestBody()ShowReqDto_AllShow showReqDtoAllShow){
        return showsService.getAllShows(showReqDtoAllShow);
    }
}
