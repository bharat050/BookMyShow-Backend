package com.example.BMS.ResponseDto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRespDto {

    private int id;

    private String name;

    private String mobile;

    private Date createdAt;

    private Date updatedAt;
}
