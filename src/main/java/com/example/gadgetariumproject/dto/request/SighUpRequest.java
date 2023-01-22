package com.example.gadgetariumproject.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SighUpRequest {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String password;
}
