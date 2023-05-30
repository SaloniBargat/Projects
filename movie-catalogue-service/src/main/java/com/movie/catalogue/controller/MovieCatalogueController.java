package com.movie.catalogue.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.catalogue.entity.MovieDetails;
import com.movie.catalogue.service.MovieCatalogueService;

@RestController
@RequestMapping("/movie-catalogue-service")
public class MovieCatalogueController {

	@Autowired
	private MovieCatalogueService movieCatService;

	@GetMapping("/viewAllMovies")
	public List<MovieDetails> getAllMovies() {
		return movieCatService.getAllMovies();
	}

	@GetMapping("/searchMovieDetails/{title}")
	public MovieDetails getMovieByTitle(@PathVariable("title") String title) {
		return movieCatService.getMovieByTitle(title);
	}

	@PostMapping("/addMovieDetails")
	public MovieDetails addMovie(@Valid @RequestBody MovieDetails movie) {
		return movieCatService.addMovie(movie);
	}

	@PutMapping("/updateMovieDetails/{title}")
	public MovieDetails updateMovie(@PathVariable("title") String title, @RequestBody @Valid MovieDetails movie) {
		return movieCatService.updateMovie(title, movie);
	}

	@DeleteMapping("/deleteMovieDetails/{title}")
	public void deleteMovie(@PathVariable("title") String title) {
		movieCatService.deleteMovie(title);
	}

}
