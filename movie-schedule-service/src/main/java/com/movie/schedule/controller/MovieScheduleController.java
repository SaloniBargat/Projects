package com.movie.schedule.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.schedule.entity.BookParkingSlotRequest;
import com.movie.schedule.entity.MovieDetails;
import com.movie.schedule.entity.MovieSchedule;
import com.movie.schedule.entity.ViewParkingSlotRequest;
import com.movie.schedule.exception.NotFoundException;
import com.movie.schedule.proxy.MovieCatalogueClientProxy;
import com.movie.schedule.service.MovieScheduleService;

@RestController
@RequestMapping("/movie-schedule-service")
public class MovieScheduleController {
	@Autowired
	private MovieScheduleService service;

	@Autowired
	private MovieCatalogueClientProxy proxy;

	@PostMapping("/addMovieSchedule")
	public ResponseEntity<String> addMovieSchedule(@RequestBody MovieSchedule movieSchedule) {
		service.addMovieSchedule(movieSchedule);
		return new ResponseEntity<>("Movie schedule added successfully", HttpStatus.OK);
	}

	@PutMapping("/updateMovieSchedule")
	public ResponseEntity<String> updateMovieSchedule(@RequestBody MovieSchedule movieSchedule) {
		service.updateMovieSchedule(movieSchedule);
		return new ResponseEntity<>("Movie schedule updated successfully", HttpStatus.OK);
	}

	@GetMapping("/getMovieScheduleForDate/{movieDate}")
	public ResponseEntity<List<MovieSchedule>> getMovieScheduleForDate(@PathVariable String movieDate) {
		List<MovieSchedule> schedules = service.getMovieScheduleForDate(movieDate);

		return new ResponseEntity<>(schedules, HttpStatus.OK);
	}

	@DeleteMapping("/removeMovieScheduleForDate/{movieDate}")
	public ResponseEntity<String> removeMovieScheduleForDate(@PathVariable String movieDate) {
		service.removeMovieScheduleForDate(movieDate);
		return new ResponseEntity<>("Movie schedules removed successfully", HttpStatus.OK);
	}

	@GetMapping("/getMovieDetails/{movieTitle}")
	public ResponseEntity<MovieDetails> getMovieDetails(@PathVariable String movieTitle) {
		MovieDetails movie = proxy.searchMovieDetails(movieTitle);
		return new ResponseEntity<>(movie, HttpStatus.OK);
	}

	@PostMapping("/viewParkingSlotAvailability")
	public ResponseEntity<Set<String>> viewParkingSlotAvailability(@RequestBody ViewParkingSlotRequest request) {
		String movieTitle = request.getMovieTitle();
		String movieDate = request.getMovieDate();
		String movieStartTime = request.getMovieStartTime();
		MovieSchedule movieSchedule = service.findByMovieTitleAndMovieDateAndShowTime(movieTitle, movieDate,
				movieStartTime);
		if (movieSchedule != null) {
			return new ResponseEntity<>(movieSchedule.getAvailableParkingSlots(), HttpStatus.OK);
		}
		throw new NotFoundException("No movie Schedule Available");
	}

	@PutMapping("/bookParkingSlot")
	public ResponseEntity<Object> bookParkingSlot(@RequestBody BookParkingSlotRequest request) {
		String movieTitle = request.getMovieTitle();
		String movieDate = request.getMovieDate();
		String movieStartTime = request.getMovieStartTime();
		String parkingSlot = request.getParkingSlot();
		double cost = service.bookParkingSlot(movieTitle, movieDate, movieStartTime, parkingSlot);
		Map<String, String> response = new HashMap<>();
		response.put("message", "Slot Booked Successfully");
		response.put("cost", String.valueOf(cost));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PutMapping("/cancelParkingSlotBooking")
	public ResponseEntity<String> cancelParkingSlotBooking(@RequestBody BookParkingSlotRequest request) {
		String movieTitle = request.getMovieTitle();
		String movieDate = request.getMovieDate();
		String movieStartTime = request.getMovieStartTime();
		String parkingSlot = request.getParkingSlot();
		service.cancelParkingSlotBooking(movieTitle, movieDate, movieStartTime, parkingSlot);
		return new ResponseEntity<>("Slot Booking Cancelled Successfully", HttpStatus.OK);
	}
}