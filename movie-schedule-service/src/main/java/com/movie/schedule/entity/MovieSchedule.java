package com.movie.schedule.entity;

import java.time.LocalDate;
import java.util.Set;

import org.springframework.data.annotation.Id;

public class MovieSchedule {
	@Id
	private String scheduleId;
	private LocalDate movieDate;
	private String showTime;
	private String movieTitle;
	private Set<String> availableParkingSlots;

	public String getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(String scheduleId) {
		this.scheduleId = scheduleId;
	}

	public LocalDate getMovieDate() {
		return movieDate;
	}

	public void setMovieDate(LocalDate movieDate) {
		this.movieDate = movieDate;
	}

	public String getShowTime() {
		return showTime;
	}

	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public Set<String> getAvailableParkingSlots() {
		return availableParkingSlots;
	}

	public void setAvailableParkingSlots(Set<String> availableParkingSlots) {
		this.availableParkingSlots = availableParkingSlots;
	}

	public MovieSchedule(String scheduleId, LocalDate movieDate, String showTime, String movieTitle,
			Set<String> availableParkingSlots) {
		super();
		this.scheduleId = scheduleId;
		this.movieDate = movieDate;
		this.showTime = showTime;
		this.movieTitle = movieTitle;
		this.availableParkingSlots = availableParkingSlots;
	}

	public MovieSchedule() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "MovieSchedule [scheduleId=" + scheduleId + ", movieDate=" + movieDate + ", showTime=" + showTime
				+ ", movieTitle=" + movieTitle + ", availableParkingSlots=" + availableParkingSlots + "]";
	}

}