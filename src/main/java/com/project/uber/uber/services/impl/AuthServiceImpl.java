package com.project.uber.uber.services.impl;

import com.project.uber.uber.dto.DriverDto;
import com.project.uber.uber.dto.SignupDto;
import com.project.uber.uber.dto.UserDto;
import com.project.uber.uber.entities.User;
import com.project.uber.uber.entities.enums.Role;
import com.project.uber.uber.exceptions.RuntimeConflictException;
import com.project.uber.uber.repositories.UserRepository;
import com.project.uber.uber.services.AuthService;
import com.project.uber.uber.services.RiderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final RiderService riderService;

    @Override
    public String login(String email, String password) {
        return "";
    }

    @Override
    @Transactional
    public UserDto signUp(SignupDto signupDto) {
        User user = userRepository.findByEmail(signupDto.getEmail()).orElse(null);
        if(user != null) {
            throw new RuntimeConflictException("Cannot signup, User already exists with this email" + signupDto.getEmail());
        }
        User mapperUser = modelMapper.map(signupDto, User.class);
        mapperUser.setRoles(Set.of(Role.RIDER));
        User savedUser = userRepository.save(mapperUser);

        riderService.createRider(savedUser);

        //TODO add wallet related service

        return modelMapper.map(savedUser, UserDto.class);
    }

    @Override
    public DriverDto onboardNewDriver(Long userUd) {
        return null;
    }
}
