package com.movie.schedule.service;

import java.util.List;

import com.movie.schedule.entity.MovieSchedule;

public interface MovieScheduleService {
	void addMovieSchedule(MovieSchedule movieSchedule);

	void updateMovieSchedule(MovieSchedule movieSchedule);

	List<MovieSchedule> getMovieScheduleForDate(String movieDate);

	void removeMovieScheduleForDate(String movieDate);

	MovieSchedule findByMovieTitleAndMovieDateAndShowTime(String movieTitle, String dateString, String showTime);

	double bookParkingSlot(String movieTitle, String movieDate, String movieStartTime, String parkingSlot);

	void cancelParkingSlotBooking(String movieTitle, String movieDate, String movieStartTime, String parkingSlot);

//	Movie getMovieDetails(String movieTitle);
}
