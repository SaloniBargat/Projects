package com.movie.booking.entity;

public class BookParkingSlotRequest {
	private String movieTitle;
	private String movieDate;
	private String movieStartTime;
	private String parkingSlot;

	public BookParkingSlotRequest() {
		super();
	}

	public BookParkingSlotRequest(String movieTitle, String movieDate, String movieStartTime, String parkingSlot) {
		super();
		this.movieTitle = movieTitle;
		this.movieDate = movieDate;
		this.movieStartTime = movieStartTime;
		this.parkingSlot = parkingSlot;
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

	public String getParkingSlot() {
		return parkingSlot;
	}

	public void setParkingSlot(String parkingSlot) {
		this.parkingSlot = parkingSlot;
	}

	@Override
	public String toString() {
		return "BookParkingSlotRequest [movieTitle=" + movieTitle + ", movieDate=" + movieDate + ", movieStartTime="
				+ movieStartTime + ", parkingSlot=" + parkingSlot + "]";
	}

}
