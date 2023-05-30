package com.movie.catalogue.service;

import java.util.List;

import com.movie.catalogue.entity.MovieDetails;

public interface MovieCatalogueServiceInterface {
	MovieDetails addMovie(MovieDetails movie);

	List<MovieDetails> getAllMovies();

	MovieDetails getMovieByTitle(String title);

	void deleteMovie(String title);

	MovieDetails updateMovie(String title, MovieDetails movie);
}
