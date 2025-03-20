package com.example.movie.domain.repository;

import com.example.movie.domain.entity.Movie;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findAllByOrderByReleaseDateDesc();
}
