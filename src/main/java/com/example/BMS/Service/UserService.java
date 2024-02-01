package com.example.BMS.Service;

import com.example.BMS.Convertors.UserConvertor;
import com.example.BMS.Model.User;
import com.example.BMS.Repository.UserRepository;
import com.example.BMS.RequestDto.UserReqDto;
import com.example.BMS.ResponseDto.UserRespDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public String addUser(UserReqDto userReqDto){
        User user = UserConvertor.userDtoToEntity(userReqDto);
        userRepository.save(user);
        return "User added successfully";
    }

    public UserRespDto getUserByName(String name){
        User user = userRepository.findByName(name);
        return UserConvertor.userEntityToDto(user);
    }

    public List<UserRespDto> getAllUsers() {
        List<User> list = userRepository.findAll();
        List<UserRespDto> ans = new ArrayList<>();
        for(User user: list){
            ans.add(UserConvertor.userEntityToDto(user));
        }
        return ans;
    }
}
