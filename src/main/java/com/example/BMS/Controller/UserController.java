package com.example.BMS.Controller;

import com.example.BMS.RequestDto.UserReqDto;
import com.example.BMS.ResponseDto.UserRespDto;
import com.example.BMS.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;
    @PostMapping("/add_user")
    public ResponseEntity<String> addUser(@RequestBody() UserReqDto userReqDto){
        String ans = userService.addUser(userReqDto);
        return new ResponseEntity<>(ans, HttpStatus.CREATED);
    }

    @GetMapping("/get_user_by_name/{name}")
    public ResponseEntity<UserRespDto> getUserByName(@PathVariable("name") String name){
        UserRespDto userRespDto = userService.getUserByName(name);
        return new ResponseEntity<>(userRespDto, HttpStatus.FOUND);
    }

    @GetMapping("/get_all_user")
    public ResponseEntity<List<UserRespDto>> getAllUser(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.FOUND);
    }
}
