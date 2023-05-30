package com.movie.booking.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.booking.entity.BookParkingSlotRequest;
import com.movie.booking.entity.BookTicket;
import com.movie.booking.entity.ViewParkingSlotRequest;
import com.movie.booking.proxy.MovieScheduleProxy;
import com.movie.booking.service.BookingService;

@RestController
@RequestMapping("/movie-booking-service")
public class BookingController {

	@Autowired
	public BookingService service;

	@Autowired
	public MovieScheduleProxy proxy;

	@PostMapping("/viewParkingSlotAvailability")
	public ResponseEntity<Set<String>> viewParkingSlotAvailability(@RequestBody ViewParkingSlotRequest request) {
		return proxy.viewParkingSlotAvailability(request);
	}

	@GetMapping(value = "/viewBookingDetails/{ticketId}")
	public BookTicket viewBookingDetails(@PathVariable int ticketId) {
		return service.getBookTicketById(ticketId);
	}

	@PostMapping(value = "/bookTicket")
	public BookTicket createBookingDetails(@RequestBody BookTicket bookticket) {
		String movieTitle = bookticket.getMovieTitle();
		Date movieDate = bookticket.getMovieDate();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String strDate = formatter.format(movieDate);
		String playTime = bookticket.getPlayTime();
		String slotNo = bookticket.getSlotNo();
		BookParkingSlotRequest request = new BookParkingSlotRequest(movieTitle, strDate, playTime, slotNo);
		ResponseEntity<Object> response = proxy.bookParkingSlot(request);
		Map<String, String> body = (Map<String, String>) response.getBody();
		bookticket.setPrice(Double.valueOf(body.get("cost")));
		return service.createBookTicket(bookticket);
	}

	@DeleteMapping(value = "/cancelBooking/{ticketId}")
	public ResponseEntity<String> cancelBooking(@PathVariable int ticketId) {
		BookTicket bookticket = viewBookingDetails(ticketId);
		String movieTitle = bookticket.getMovieTitle();
		Date movieDate = bookticket.getMovieDate();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String strDate = formatter.format(movieDate);
		String playTime = bookticket.getPlayTime();
		String slotNo = bookticket.getSlotNo();
		BookParkingSlotRequest request = new BookParkingSlotRequest(movieTitle, strDate, playTime, slotNo);
		proxy.cancelParkingSlotBooking(request);
		service.cancelBooking(ticketId);
		return new ResponseEntity<>("Booking cancelled successfully", HttpStatus.OK);
	}

}
