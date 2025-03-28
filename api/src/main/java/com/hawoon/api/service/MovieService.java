package com.hawoon.api.service;


import com.hawoon.api.dto.MovieResponseDto;
import com.hawoon.api.dto.ScheduleResponseDto;
import com.hawoon.domain.dto.MovieScheduleDto;
import com.hawoon.domain.entity.Genre;
import com.hawoon.domain.entity.Movie;
import com.hawoon.domain.repository.MovieRepository;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MovieService {

    private final MovieRepository movieRepository;

    @Transactional(readOnly = true)
    public List<MovieResponseDto> getMovieByTheaterId(Long theaterId, String title, Genre genre) {
        List<MovieScheduleDto> dtos = movieRepository.findNowShowingMovies(theaterId, title, genre);

        Map<Long, List<MovieScheduleDto>> grouped = dtos.stream()
                .collect(Collectors.groupingBy(MovieScheduleDto::getMovieId));

        return grouped.values().stream()
                .map(group -> {
                    MovieScheduleDto first = group.get(0);

                    List<ScheduleResponseDto> schedules = group.stream()
                            .map(ScheduleResponseDto::from)
                            .toList();

                    return MovieResponseDto.fromGroup(first, schedules);
                })
                .toList();
    }
}
