package com.movie.booking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.booking.entity.BookTicket;
import com.movie.booking.repository.BookTicketDAO;

@Service
public class BookingService {

	@Autowired
	BookTicketDAO dao;

	@Autowired
	private SequenceGeneratorService generator;

	// Method to view parking slot availability for a movie
//	public void viewParkingSlotAvailability(String movieTitle, String movieDate, String movieStartTime) {
	// Convert movieDate String to Date object
//		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//		Date parsedDate;
//		try {
//			parsedDate = dateFormat.parse(movieDate);
//		} catch (Exception e) {
//			throw new IllegalArgumentException("Invalid date format. Please use dd/MM/yyyy format.");
//		}

	// Search parking slot repository for matching record
//		ParkingSlotRepository repository = new ParkingSlotRepository();
//		List<ParkingSlots> parkingSlots = repository.getParkingSlots(movieTitle, parsedDate, movieStartTime);
//        if (parkingSlots.isEmpty()) {
//            throw new NoParkingSlotFoundException("No parking slots available for " + movieTitle + " on " + movieDate + " at " + movieStartTime);
//        }

	// Display parking slot availability
//		System.out.println(
//				"Parking slot availability for " + movieTitle + " on " + movieDate + " at " + movieStartTime + ":");
//		for (ParkingSlots parkingSlot : parkingSlots) {
//			System.out.println(parkingSlot.toString());
//		}
//	}

	public BookTicket getBookTicketById(int ticketId) {
		return dao.findById(ticketId).get();
	}

	public BookTicket createBookTicket(BookTicket book) {
		book.setTicketId(generator.getSequenceNumber(BookTicket.SEQUENCE_NAME));
		return dao.save(book);
	}

	public void cancelBooking(int ticketId) {
		dao.deleteById(ticketId);
	}

}
