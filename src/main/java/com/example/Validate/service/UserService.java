package com.example.Validate.service;

import com.example.Validate.dto.UserDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public void createUser(@Valid @NotNull UserDto user){}

}
