package com.example.gadgetariumproject.db.service;

import com.example.gadgetariumproject.db.repository.UserRepository;
import com.example.gadgetariumproject.dto.request.AuthRequest;
import com.example.gadgetariumproject.dto.response.AuthResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public AuthResponse registration(AuthRequest authRequest) {
        if (!userRepository.existsByEmail(authRequest.getEmail)) {

        }
    }
}
