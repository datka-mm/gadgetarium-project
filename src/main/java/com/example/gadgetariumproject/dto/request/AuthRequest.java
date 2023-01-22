package com.example.gadgetariumproject.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
}
