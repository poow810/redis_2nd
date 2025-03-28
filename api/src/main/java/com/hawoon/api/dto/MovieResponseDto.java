package com.hawoon.api.dto;

import com.hawoon.domain.dto.MovieScheduleDto;
import com.hawoon.domain.entity.Genre;
import com.hawoon.domain.entity.Movie;
import com.hawoon.domain.entity.Rating;
import com.hawoon.domain.entity.Schedule;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class MovieResponseDto {
    private final Long movieId;
    private final String title;
    private final String thumbnailUrl;
    private final Genre genre;
    private final Rating rating;
    private final LocalDateTime releaseDate;
    private final int runningTime;
    private final String theaterName;
    private final List<ScheduleResponseDto> schedules;

    public static MovieResponseDto fromGroup(MovieScheduleDto base, List<ScheduleResponseDto> schedules) {
        return MovieResponseDto.builder()
                .movieId(base.getMovieId())
                .title(base.getTitle())
                .thumbnailUrl(base.getThumbnailUrl())
                .genre(base.getGenre())
                .rating(base.getRating())
                .releaseDate(base.getReleaseDate())
                .runningTime(base.getRunningTime())
                .theaterName(base.getTheaterName())
                .schedules(schedules)
                .build();
    }
}
