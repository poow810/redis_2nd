package com.hawoon.domain.repository;

import com.hawoon.domain.dto.MovieScheduleDto;
import com.hawoon.domain.entity.Genre;
import java.util.List;

public interface CustomMovieRepository {

    List<MovieScheduleDto> findNowShowingMovies(Long theaterId, String title, Genre genre);

}
