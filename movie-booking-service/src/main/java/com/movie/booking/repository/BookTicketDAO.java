package com.movie.booking.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.movie.booking.entity.BookTicket;

@Repository
public interface BookTicketDAO extends MongoRepository<BookTicket, Integer> {

	// BookTicket findById(int ticketId);

}
