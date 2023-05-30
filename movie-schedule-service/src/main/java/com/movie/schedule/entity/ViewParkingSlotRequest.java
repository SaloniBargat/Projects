package com.movie.schedule.entity;

public class ViewParkingSlotRequest {
	private String movieTitle;
	private String movieDate;
	private String movieStartTime;

	public ViewParkingSlotRequest() {
		super();
	}

	public ViewParkingSlotRequest(String movieTitle, String movieDate, String movieStartTime) {
		super();
		this.movieTitle = movieTitle;
		this.movieDate = movieDate;
		this.movieStartTime = movieStartTime;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public String getMovieDate() {
		return movieDate;
	}

	public void setMovieDate(String movieDate) {
		this.movieDate = movieDate;
	}

	public String getMovieStartTime() {
		return movieStartTime;
	}

	public void setMovieStartTime(String movieStartTime) {
		this.movieStartTime = movieStartTime;
	}

}
