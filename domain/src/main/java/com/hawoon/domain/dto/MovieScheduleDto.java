package com.hawoon.domain.dto;

import com.hawoon.domain.entity.Genre;
import com.hawoon.domain.entity.Rating;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MovieScheduleDto {
    private Long movieId;
    private String title;
    private Rating rating;
    private LocalDateTime releaseDate;
    private String thumbnailUrl;
    private int runningTime;
    private Genre genre;
    private String theaterName;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
}
