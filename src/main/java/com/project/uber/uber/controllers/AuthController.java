package com.project.uber.uber.controllers;

import com.project.uber.uber.dto.SignupDto;
import com.project.uber.uber.dto.UserDto;
import com.project.uber.uber.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    UserDto signUp(@RequestBody SignupDto signupDto){
        return authService.signUp(signupDto);
    }
}
