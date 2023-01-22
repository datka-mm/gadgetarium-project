package com.example.gadgetariumproject.api;

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

    private UserService userService;

    @Operation(summary = "Sign in", description = "Any user can register")
    @PostMapping
    public AuthResponse registration(@RequestBody AuthRequest authRequest) {
        return userService.registration(authRequest);
    }
}
