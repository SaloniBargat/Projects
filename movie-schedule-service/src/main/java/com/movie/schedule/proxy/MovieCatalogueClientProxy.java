package com.movie.schedule.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.movie.schedule.entity.MovieDetails;

@FeignClient(name = "movie-catalogue-service", url = "localhost:7080")
public interface MovieCatalogueClientProxy {

	@GetMapping("/movie-catalogue-service/searchMovieDetails/{movieTitle}")
	MovieDetails searchMovieDetails(@PathVariable String movieTitle);

}
