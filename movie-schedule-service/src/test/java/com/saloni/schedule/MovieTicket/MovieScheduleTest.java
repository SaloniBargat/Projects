package com.saloni.schedule.MovieTicket;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.movie.schedule.entity.MovieSchedule;
import com.movie.schedule.exception.NotFoundException;
import com.movie.schedule.repository.MovieScheduleRepository;
import com.movie.schedule.service.MovieScheduleService;

public class MovieScheduleTest {
	private MovieScheduleRepository movieScheduleRepository;
	// private MovieCatalogueClient movieCatalogueClient;
	private MovieScheduleService movieScheduleService;

	@BeforeEach
	public void setUp() {
		movieScheduleRepository = Mockito.mock(MovieScheduleRepository.class);
		// movieCatalogueClient = Mockito.mock(MovieCatalogueClient.class);
		// movieScheduleService = new MovieScheduleService(movieScheduleRepository,
		// movieCatalogueClient);
	}

	@Test
	public void testAddMovieSchedule() {
		LocalDate movieDate = null;
		MovieSchedule movieSchedule = new MovieSchedule("1", movieDate, "12:00 PM", "DDLJ", null);
		movieSchedule.setScheduleId("1");
		movieSchedule.setMovieDate(LocalDate.now());
		movieSchedule.setShowTime("12:00 PM");
		movieSchedule.setMovieTitle("Avengers: Endgame");
		Set<String> availableParkingSlots = new HashSet<>();
		availableParkingSlots.add("A1");
		availableParkingSlots.add("B2");
		movieSchedule.setAvailableParkingSlots(availableParkingSlots);

		Mockito.when(movieScheduleRepository.save(movieSchedule)).thenReturn(movieSchedule);

		// MovieSchedule savedMovieSchedule = movieScheduleService.addMovieSchedule();

		// Assertions.assertEquals(movieSchedule, savedMovieSchedule);
	}

	@Test
	public void testUpdateMovieSchedule() {
		Date movieDate = null;
		MovieSchedule movieSchedule = new MovieSchedule(null, null, null, null, null);
		movieSchedule.setScheduleId("1");
		movieSchedule.setMovieDate(LocalDate.now());
		movieSchedule.setShowTime("12:00 PM");
		movieSchedule.setMovieTitle("Avengers: Endgame");
		Set<String> availableParkingSlots = new HashSet<>();
		availableParkingSlots.add("A1");
		availableParkingSlots.add("B2");
		movieSchedule.setAvailableParkingSlots(availableParkingSlots);

		Mockito.when(movieScheduleRepository.existsById("1")).thenReturn(true);
		Mockito.when(movieScheduleRepository.save(movieSchedule)).thenReturn(movieSchedule);

		// MovieSchedule updatedMovieSchedule =
		// movieScheduleService.updateMovieSchedule();

		// Assertions.assertEquals(movieSchedule, updatedMovieSchedule);
	}

	@Test
	public void testUpdateMovieSchedule_ThrowsException() {
		Date movieDate = null;
		MovieSchedule movieSchedule = new MovieSchedule(null, null, null, null, null);
		movieSchedule.setScheduleId("2");
		movieSchedule.setMovieDate(LocalDate.now());
		movieSchedule.setShowTime("12:00 PM");
		movieSchedule.setMovieTitle("Avengers: Endgame");
		Set<String> availableParkingSlots = new HashSet<>();
		availableParkingSlots.add("A1");
		availableParkingSlots.add("B2");
		movieSchedule.setAvailableParkingSlots(availableParkingSlots);

		Mockito.when(movieScheduleRepository.existsById("2")).thenReturn(false);

		Assertions.assertThrows(NotFoundException.class, () -> {
			movieScheduleService.updateMovieSchedule(movieSchedule);
		});
	}

	@Test
	public void testGetMovieScheduleForDate() {
		LocalDate movieDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String movieDateString = movieDate.format(formatter);

		List<MovieSchedule> movieSchedules = new ArrayList<>();
		MovieSchedule movieSchedule = new MovieSchedule(null, null, null, null, null);
		movieSchedule.setScheduleId("1");
		movieSchedule.setMovieDate(movieDate);
		movieSchedule.setShowTime("12");
	}
}