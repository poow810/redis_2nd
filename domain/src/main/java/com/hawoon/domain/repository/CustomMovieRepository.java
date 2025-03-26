package com.hawoon.domain.repository;

import com.hawoon.domain.entity.Genre;
import com.hawoon.domain.entity.Movie;
import java.util.List;

public interface CustomMovieRepository {

    List<Movie> findNowShowingMovies(Long theaterId, String title, Genre genre);

}
