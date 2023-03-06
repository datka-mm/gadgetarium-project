package com.example.gadgetariumproject.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/comment")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
@Tag(name = "Comment API", description = "All endpoints of comment")
public class CommentAPI {

    private final CommentService service;

    @Operation(summary = "Add comment", description = "Add new comment")
    @PostMapping
    public CommentResponse addComment(@RequestBody CommentRequest request) {
        return service.addComment(request);
    }

}
