package com.example.movie.domain.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String thumbnailUrl;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    @Enumerated(EnumType.STRING)
    private Rating rating;

    private LocalDate releaseDate;
    private int runningTime;

    @Builder
    public Movie(String title, String thumbnailUrl, Genre genre, Rating rating, LocalDate releaseDate, int runningTime) {
        this.title = title;
        this.thumbnailUrl = thumbnailUrl;
        this.genre = genre;
        this.rating = rating;
        this.releaseDate = releaseDate;
        this.runningTime = runningTime;
    }
}