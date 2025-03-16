package com.example.movie.domain.repository;

import com.example.movie.domain.entity.Schedule;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    List<Schedule> findByMovieIdOrderByStartAtAsc(Long movieId);
}
