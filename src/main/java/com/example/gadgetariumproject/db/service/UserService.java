package com.example.gadgetariumproject.db.service;

import com.example.gadgetariumproject.config.jwt.JwtTokenUtil;
import com.example.gadgetariumproject.db.model.User;
import com.example.gadgetariumproject.db.repository.UserRepository;
import com.example.gadgetariumproject.dto.request.SighUpRequest;
import com.example.gadgetariumproject.dto.response.AuthResponse;
import com.example.gadgetariumproject.enums.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtTokenUtil jwtUtil;


    public AuthResponse registration(SighUpRequest sighUpRequest) {
        if (userRepository.existsByEmail(sighUpRequest.getEmail())) {
            throw new BadCredentialsException(String.format("This email: %s is already in use", sighUpRequest.getEmail()));
        }

        User user = new User(sighUpRequest);
        user.setPassword(passwordEncoder.encode(sighUpRequest.getPassword()));
        user.setRole(Role.USER);
        userRepository.save(user);

        String jwtToken = jwtUtil.generateToken(user.getEmail());
        return new AuthResponse();
    }
}
