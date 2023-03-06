package com.example.gadgetariumproject.dto.request;

import com.example.gadgetariumproject.enums.Rating;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CommentRequest {

    private Long productId;
    private String text;
    private Rating rating;
}
