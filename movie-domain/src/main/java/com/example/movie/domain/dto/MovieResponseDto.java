package com.example.movie.domain.dto;

import com.example.movie.domain.entity.Movie;
import com.example.movie.domain.entity.Schedule;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MovieResponseDto {
    private Long id;
    private String title;
    private String genre;
    private String rating;
    private String releaseDate;
    private int runningTime;
    private String theaterName;
    private List<LocalDateTime> scheduleTimes; // 상영 시간표

    public static MovieResponseDto fromEntity(Movie movie, List<Schedule> schedules) {
        return MovieResponseDto.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .genre(movie.getGenre().name())
                .rating(movie.getRating().name())
                .releaseDate(movie.getReleaseDate().toString())
                .runningTime(movie.getRunningTime())
                .theaterName(schedules.get(0).getTheater().getTheaterName())
                .scheduleTimes(
                        schedules.stream()
                                .map(Schedule::getStartAt)
                                .sorted()
                                .collect(Collectors.toList())
                )
                .build();
    }
}