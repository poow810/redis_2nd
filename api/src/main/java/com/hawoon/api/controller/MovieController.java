package com.hawoon.api.controller;



import com.hawoon.api.dto.request.MovieSearchRequestDto;
import com.hawoon.api.dto.response.MovieResponseDto;
import com.hawoon.api.service.MovieService;
import com.hawoon.domain.entity.Genre;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
@Slf4j
public class MovieController {

    private final MovieService movieService;

    @GetMapping
    public ResponseEntity<List<MovieResponseDto>> getAllMovies(@Valid @ModelAttribute MovieSearchRequestDto request) {
        List<MovieResponseDto> movies = movieService.getMovieByTheaterId(
                request.theater_id(), request.title(), request.genre()
        );
        return ResponseEntity.ok(movies);
    }
}
