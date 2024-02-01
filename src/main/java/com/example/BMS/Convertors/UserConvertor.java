package com.example.BMS.Convertors;

import com.example.BMS.Model.User;
import com.example.BMS.RequestDto.UserReqDto;
import com.example.BMS.ResponseDto.UserRespDto;

public class UserConvertor {

    public static User userDtoToEntity(UserReqDto userReqDto){
        return User.builder().
                name(userReqDto.getName()).mobile(userReqDto.getMobile()).
                build();
    }

    public static UserRespDto userEntityToDto(User user){
        return UserRespDto.builder().
                id(user.getId()).name(user.getName()).mobile(user.getMobile()).
                createdAt(user.getCreatedAt()).updatedAt(user.getUpdatedAt()).build();
    }
}
