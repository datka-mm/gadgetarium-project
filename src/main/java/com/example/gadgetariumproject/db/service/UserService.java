package com.example.gadgetariumproject.db.service;

import com.example.gadgetariumproject.config.jwt.JwtTokenUtil;
import com.example.gadgetariumproject.db.model.User;
import com.example.gadgetariumproject.db.repository.UserRepository;
import com.example.gadgetariumproject.dto.request.SighUpRequest;
import com.example.gadgetariumproject.dto.request.SignInRequest;
import com.example.gadgetariumproject.dto.response.AuthResponse;
import com.example.gadgetariumproject.enums.Role;
import com.example.gadgetariumproject.exceptions.BadCredentialException;
import com.example.gadgetariumproject.exceptions.BadRequestException;
import com.example.gadgetariumproject.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenUtil jwtUtil;


    public AuthResponse registration(SighUpRequest sighUpRequest) {
        if (userRepository.existsByEmail(sighUpRequest.getEmail())) {
            throw new BadCredentialException(String.format("This email: %s is already in use", sighUpRequest.getEmail()));
        }

        User user = new User(sighUpRequest);
        user.setPassword(passwordEncoder.encode(sighUpRequest.getPassword()));
        user.setRole(Role.USER);
        userRepository.save(user);

        String jwtToken = jwtUtil.generateToken(user.getEmail());
        return new AuthResponse(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getPhoneNumber(),
                user.getEmail(),
                jwtToken
        );
    }

    public AuthResponse login(SignInRequest request) {
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow(
                () -> new NotFoundException(String.format("User with email: %s not found!", request.getEmail())
                )
        );

        if (request.getPassword().isBlank()) {
            throw new BadRequestException("Password can't be empty!");
        }

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new BadCredentialException("Incorrect password!");
        }

        String jwtToken = jwtUtil.generateToken(user.getEmail());
        return new AuthResponse(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getPhoneNumber(),
                user.getEmail(),
                jwtToken
        );
    }
}
