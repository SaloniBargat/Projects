package com.movie.catalogue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.catalogue.entity.MovieDetails;
import com.movie.catalogue.exception.MovieNotFoundException;
import com.movie.catalogue.repository.MovieRepository;

@Service
public class MovieCatalogueService {

	@Autowired
	MovieRepository movieRepository;

	public MovieDetails addMovie(MovieDetails movie) {
		return movieRepository.save(movie);
	}

	public List<MovieDetails> getAllMovies() {
		return movieRepository.findAll();
	}

	public MovieDetails getMovieByTitle(String title) {
		MovieDetails existingMovie = movieRepository.findByMovieTitle(title);
		if (existingMovie == null) {
			throw new MovieNotFoundException("Movie not found");
		}
		return existingMovie;
	}

	public void deleteMovie(String title) {
		MovieDetails existingMovie = movieRepository.findByMovieTitle(title);
		if (existingMovie == null) {
			throw new MovieNotFoundException("Movie not found");
		}
		movieRepository.deleteByMovieTitle(title);
	}

	public MovieDetails updateMovie(String title, MovieDetails movie) {
		MovieDetails existingMovie = movieRepository.findByMovieTitle(title);
		if (existingMovie == null) {
			throw new MovieNotFoundException("Movie not found");
		}
		existingMovie.setMovieTitle(movie.getMovieTitle());
		existingMovie.setDescription(movie.getDescription());
		existingMovie.setGenre(movie.getGenre());
		existingMovie.setImdbRating(movie.getImdbRating());
		return movieRepository.save(existingMovie);
	}

}
