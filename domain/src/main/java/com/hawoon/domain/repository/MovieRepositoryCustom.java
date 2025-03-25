package com.hawoon.domain.repository;

import com.hawoon.domain.entity.Movie;
import java.util.List;

public interface MovieRepositoryCustom {

    List<Movie> findNowShowingMovies(Long theaterId);

}
