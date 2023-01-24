package com.example.gadgetariumproject.api;

import com.example.gadgetariumproject.db.service.UserService;
import com.example.gadgetariumproject.dto.request.SighUpRequest;
import com.example.gadgetariumproject.dto.response.AuthResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/public")
@CrossOrigin(origins = "*", maxAge = 3600)
@Tag(name = "Auth API", description = "Registration and authentication")
public class AuthAPI {

    private final UserService userService;

    @Operation(summary = "Sign up", description = "Any user can register")
    @PostMapping
    public AuthResponse registration(@RequestBody SighUpRequest authRequest) {
        return userService.registration(authRequest);
    }
}
