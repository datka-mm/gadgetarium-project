package com.example.gadgetariumproject.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CommentedUserResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String image;
}
