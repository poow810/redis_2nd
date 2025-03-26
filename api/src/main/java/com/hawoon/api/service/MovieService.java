package com.hawoon.api.service;


import com.hawoon.api.dto.MovieResponseDto;
import com.hawoon.domain.entity.Genre;
import com.hawoon.domain.entity.Movie;
import com.hawoon.domain.repository.MovieRepository;
import java.util.List;
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

        List<Movie> movies = movieRepository.findNowShowingMovies(theaterId, title, genre);

        List<MovieResponseDto> movieResponseDtos = movies.stream()
                .map(movie -> MovieResponseDto.fromEntity(movie, movie.getSchedules())).toList();

        return movieResponseDtos;
    }
}
