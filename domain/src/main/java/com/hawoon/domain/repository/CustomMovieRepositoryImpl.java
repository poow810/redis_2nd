package com.hawoon.domain.repository;

import com.hawoon.domain.entity.Genre;
import com.hawoon.domain.entity.Movie;
import com.hawoon.domain.entity.QMovie;
import com.hawoon.domain.entity.QSchedule;
import com.hawoon.domain.entity.QTheater;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.core.types.dsl.BooleanExpression;

import java.util.List;

public class CustomMovieRepositoryImpl implements CustomMovieRepository {

    private final JPAQueryFactory queryFactory;

    public CustomMovieRepositoryImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    @Override
    public List<Movie> findNowShowingMovies(Long theaterId, String title, Genre genre) {
        QMovie movie = QMovie.movie;
        QSchedule schedule = QSchedule.schedule;
        QTheater theater = QTheater.theater;

        return queryFactory
                .selectDistinct(movie)
                .from(movie)
                .join(movie.schedules, schedule).fetchJoin()
                .join(schedule.theater, theater).fetchJoin()
                .where(
                        theater.id.eq(theaterId),
                        movie.releaseDate.loe(schedule.startAt),
                        titleContains(title),
                        genreEquals(genre)
                )
                .orderBy(
                        movie.releaseDate.desc(),
                        schedule.startAt.asc()
                )
                .fetch();
    }

    private BooleanExpression titleContains(String title) {
        return title != null ? QMovie.movie.title.containsIgnoreCase(title) : null;
    }

    private BooleanExpression genreEquals(Genre genre) {
        return genre != null ? QMovie.movie.genre.eq(genre) : null;
    }
}
