package com.example.gadgetariumproject.db.model;

import com.example.gadgetariumproject.enums.Rating;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "comments")
@Getter
@Setter
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    private Rating rating;

    private LocalDateTime commentedTime;

    @ManyToOne(cascade = {DETACH, REFRESH, MERGE})
    private User commentedUser;

    @OneToOne(cascade = {ALL})
    private Answer answer;
}
