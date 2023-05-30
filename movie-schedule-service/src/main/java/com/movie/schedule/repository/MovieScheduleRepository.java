package com.movie.schedule.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.movie.schedule.entity.MovieSchedule;

public interface MovieScheduleRepository extends MongoRepository<MovieSchedule, String> {

	List<MovieSchedule> findByMovieDate(LocalDate movieDate);

	void deleteByMovieDate(LocalDate movieDate);

	MovieSchedule findByMovieTitleAndMovieDateAndShowTime(String movieTitle, LocalDate movieDate, String showTime);
}
