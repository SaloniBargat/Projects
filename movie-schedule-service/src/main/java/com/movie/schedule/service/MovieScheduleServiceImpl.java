package com.movie.schedule.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.schedule.entity.MovieSchedule;
import com.movie.schedule.exception.NotFoundException;
//import com.saloni.schedule.moviecatalogue.MovieCatalogueClient;
import com.movie.schedule.repository.MovieScheduleRepository;

@Service
public class MovieScheduleServiceImpl implements MovieScheduleService {

	@Autowired
	private MovieScheduleRepository repository;

	public Set<String> initializeAvailableSlots() {
		Set<String> availableSlots = new TreeSet<>();
		int alphabetIndex = 65;
		for (int i = 0; i < 6; i++) {
			for (int j = 1; j <= 10; j++) {
				availableSlots.add(Character.toString(alphabetIndex) + j);
			}
			alphabetIndex++;
		}
		return availableSlots;
	}

	@Override
	public void addMovieSchedule(MovieSchedule movieSchedule) {
		movieSchedule.setAvailableParkingSlots(initializeAvailableSlots());
		repository.save(movieSchedule);
	}

	@Override
	public void updateMovieSchedule(MovieSchedule movieSchedule) {
		String scheduleId = movieSchedule.getScheduleId();
		MovieSchedule existingSchedule = repository.findById(scheduleId)
				.orElseThrow(() -> new NotFoundException("Movie schedule not found for id " + scheduleId));
		existingSchedule.setMovieDate(movieSchedule.getMovieDate());
		existingSchedule.setShowTime(movieSchedule.getShowTime());
		existingSchedule.setMovieTitle(movieSchedule.getMovieTitle());
		repository.save(existingSchedule);
	}

	@Override
	public List<MovieSchedule> getMovieScheduleForDate(String dateString) {
		LocalDate movieDate = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		return repository.findByMovieDate(movieDate);
	}

	@Override
	public void removeMovieScheduleForDate(String dateString) {
		LocalDate movieDate = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		repository.deleteByMovieDate(movieDate);
	}

	@Override
	public MovieSchedule findByMovieTitleAndMovieDateAndShowTime(String movieTitle, String dateString,
			String showTime) {
		LocalDate movieDate = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		return repository.findByMovieTitleAndMovieDateAndShowTime(movieTitle, movieDate, showTime);
	}

	@Override
	public double bookParkingSlot(String movieTitle, String movieDate, String movieStartTime, String parkingSlot) {
		MovieSchedule dbSchedule = findByMovieTitleAndMovieDateAndShowTime(movieTitle, movieDate, movieStartTime);
		if (dbSchedule == null) {
			throw new NotFoundException("Movie schedule not found");
		}
		Set<String> availableParkingSlots = dbSchedule.getAvailableParkingSlots();
		if (!availableParkingSlots.contains(parkingSlot)) {
			throw new NotFoundException("Parking slot is already booked!");
		}
		availableParkingSlots.remove(parkingSlot);
		dbSchedule.setAvailableParkingSlots(availableParkingSlots);
		repository.save(dbSchedule);
		return calculateCost(parkingSlot);
	}

	@Override
	public void cancelParkingSlotBooking(String movieTitle, String movieDate, String movieStartTime,
			String parkingSlot) {
		MovieSchedule dbSchedule = findByMovieTitleAndMovieDateAndShowTime(movieTitle, movieDate, movieStartTime);
		if (dbSchedule == null) {
			throw new NotFoundException("Movie schedule not found");
		}
		Set<String> availableParkingSlots = dbSchedule.getAvailableParkingSlots();
		if (availableParkingSlots.contains(parkingSlot)) {
			throw new NotFoundException("Parking slot not booked yet!");
		}
		availableParkingSlots.add(parkingSlot);
		dbSchedule.setAvailableParkingSlots(availableParkingSlots);
		repository.save(dbSchedule);
	}

	public double calculateCost(String parkingSlot) {
		double cost = 0;
		if (parkingSlot.charAt(0) == 'A' || parkingSlot.charAt(0) == 'B') {
			cost = 100;
		} else if (parkingSlot.charAt(0) == 'C' || parkingSlot.charAt(0) == 'D') {
			cost = 60;
		} else
			cost = 30;
		return cost;
	}

}
