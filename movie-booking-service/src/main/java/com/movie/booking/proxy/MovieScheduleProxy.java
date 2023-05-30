package com.movie.booking.proxy;

import java.util.Set;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.movie.booking.entity.BookParkingSlotRequest;
import com.movie.booking.entity.ViewParkingSlotRequest;

@FeignClient(name = "movie-schedule-service", url = "localhost:8080")
public interface MovieScheduleProxy {
	@PostMapping("/movie-schedule-service/viewParkingSlotAvailability")
	public ResponseEntity<Set<String>> viewParkingSlotAvailability(@RequestBody ViewParkingSlotRequest request);

	@PutMapping("/movie-schedule-service/bookParkingSlot")
	public ResponseEntity<Object> bookParkingSlot(@RequestBody BookParkingSlotRequest request);

	@PutMapping("/movie-schedule-service/cancelParkingSlotBooking")
	public ResponseEntity<String> cancelParkingSlotBooking(@RequestBody BookParkingSlotRequest request);
}
