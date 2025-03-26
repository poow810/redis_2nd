package com.hawoon.api.controller;



import com.hawoon.api.dto.MovieResponseDto;
import com.hawoon.api.service.MovieService;
import com.hawoon.domain.entity.Genre;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
    public ResponseEntity<List<MovieResponseDto>> getAllMovies(
            @RequestParam("theater_id") Long theaterId,
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "genre", required = false) Genre genre
    ) {
        List<MovieResponseDto> movies = movieService.getMovieByTheaterId(theaterId, title, genre);
        return ResponseEntity.ok(movies);
    }
}
