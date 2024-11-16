package com.project.uber.uber.services;

import com.project.uber.uber.dto.DriverDto;
import com.project.uber.uber.dto.SignupDto;
import com.project.uber.uber.dto.UserDto;

public interface AuthService {
    String login(String email, String password);

    UserDto signUp(SignupDto signupDto);

    DriverDto onboardNewDriver(Long userUd);
}
