package com.example.gadgetariumproject.dto.response;

import com.example.gadgetariumproject.enums.Rating;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class CommentResponse {

    private Long id;
    private String text;
    private Rating rating;
    private LocalDateTime commentedTime;
    private CommentedUserResponse userResponse;
}
