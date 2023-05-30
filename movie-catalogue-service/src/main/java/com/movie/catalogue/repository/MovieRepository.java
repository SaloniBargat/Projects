package com.movie.catalogue.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.movie.catalogue.entity.MovieDetails;

public interface MovieRepository extends MongoRepository<MovieDetails, String> {
	void deleteByMovieTitle(String title);

	MovieDetails findByMovieTitle(String title);
}
