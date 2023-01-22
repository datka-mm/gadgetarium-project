package com.example.gadgetariumproject.db.service;

import com.example.gadgetariumproject.db.model.User;
import com.example.gadgetariumproject.db.repository.UserRepository;
import com.example.gadgetariumproject.dto.request.SighUpRequest;
import com.example.gadgetariumproject.dto.response.AuthResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public AuthResponse registration(SighUpRequest sighUpRequest) {
        if (userRepository.existsByEmail(sighUpRequest.getEmail())) {
            throw new BadCredentialsException(String.format("This email: %s is already in use", sighUpRequest.getEmail()));
        }

        User user = new User(sighUpRequest);

    }
}
