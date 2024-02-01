package com.example.BMS.Repository;

import com.example.BMS.Model.User;
import com.example.BMS.ResponseDto.UserRespDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    public User findByName(String name);
}
