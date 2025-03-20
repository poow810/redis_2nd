package com.example.movie.api.service;


import com.example.movie.api.dto.MovieResponseDto;
import com.example.movie.domain.entity.Movie;
import com.example.movie.domain.entity.Schedule;
import com.example.movie.domain.repository.MovieRepository;
import com.example.movie.domain.repository.ScheduleRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;
    private final ScheduleRepository scheduleRepository;

    public List<MovieResponseDto> getMovies() {
        List<Movie> movies = movieRepository.findAllByOrderByReleaseDateDesc();

        return movies.stream()
                .map(movie -> {
                    List<Schedule> schedules = scheduleRepository.findByMovieIdOrderByStartAtAsc(movie.getId());
                    if (!schedules.isEmpty()) {
                        return MovieResponseDto.fromEntity(movie, schedules);
                    }
                    return null;
                })
                .filter(dto -> dto != null)
                .collect(Collectors.toList());
    }
}
