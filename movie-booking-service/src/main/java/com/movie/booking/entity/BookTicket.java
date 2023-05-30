package com.movie.booking.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

public class BookTicket {

	@Id
	private int ticketId;
	private String carNo;
	private String movieTitle;
	private Date movieDate;
	private String playTime;
	private String slotNo;
	private double price;

	@Transient
	public static final String SEQUENCE_NAME = "bookTicket_sequence";

	// constructor
	public BookTicket(int ticketId, String carNo, String movieTitle, Date movieDate, String playTime, String slotNo,
			double price) {
		super();
		this.ticketId = ticketId;
		this.carNo = carNo;
		this.movieTitle = movieTitle;
		this.movieDate = movieDate;
		this.playTime = playTime;
		this.slotNo = slotNo;
		this.price = price;
	}

	// default-constructor
	public BookTicket() {
		super();
		// TODO Auto-generated constructor stub
	}

	// getters and setters

	// toString method

	public int getTicketId() {
		return ticketId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "BookTicket [ticketId=" + ticketId + ", carNo=" + carNo + ", movieTitle=" + movieTitle + ", movieDate="
				+ movieDate + ", playTime=" + playTime + ", slotNo=" + slotNo + ", price=" + price + "]";
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public String getCarNo() {
		return carNo;
	}

	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public Date getMovieDate() {
		return movieDate;
	}

	public void setMovieDate(Date movieDate) {
		this.movieDate = movieDate;
	}

	public String getPlayTime() {
		return playTime;
	}

	public void setPlayTime(String playTime) {
		this.playTime = playTime;
	}

	public String getSlotNo() {
		return slotNo;
	}

	public void setSlotNo(String slotNo) {
		this.slotNo = slotNo;
	}

}
