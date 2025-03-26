package com.hawoon.domain.repository;

import com.hawoon.domain.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>, CustomMovieRepository {
}
