package com.example.movie.domain.repository;

import com.example.movie.domain.entity.Schedule;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    List<Schedule> findByMovieIdOrderByStartAtAsc(Long movieId);
}
