package com.project.uber.uber.services.impl;

import com.project.uber.uber.dto.DriverDto;
import com.project.uber.uber.dto.SignupDto;
import com.project.uber.uber.dto.UserDto;
import com.project.uber.uber.services.AuthService;

public class AuthServiceImpl implements AuthService {
    @Override
    public String login(String email, String password) {
        return "";
    }

    @Override
    public UserDto signUp(SignupDto signupDto) {
        return null;
    }

    @Override
    public DriverDto onboardNewDriver(Long userUd) {
        return null;
    }
}
