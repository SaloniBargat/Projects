package com.movie.booking.service;

import jakarta.persistence.Id;

public class DbSequence {
	
	@Id
	private String id;
	private int sequenceNumber;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
//	public int getSequenceNumber() {
//		return sequenceNumber;
//	}
	public void setSequenceNumber(int sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}
	public DbSequence() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DbSequence(String id, int sequenceNumber) {
		super();
		this.id = id;
		this.sequenceNumber = sequenceNumber;
	}
	public int getSequenceNumber() {
		// TODO Auto-generated method stub
		return sequenceNumber;
	}
	
	


}
