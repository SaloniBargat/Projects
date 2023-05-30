package com.movie.schedule.entity;

public class MovieDetails {
	private String movieId;
	private String movieTitle;
	private String description;
	private String genre;
	private double imdbRating;

	public MovieDetails() {
		super();

	}

	public MovieDetails(String movieId, String movieTitle, String description, String genre, double imdbRating) {
		super();
		this.movieId = movieId;
		this.movieTitle = movieTitle;
		this.description = description;
		this.genre = genre;
		this.imdbRating = imdbRating;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String id) {
		this.movieId = id;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public double getImdbRating() {
		return imdbRating;
	}

	public void setImdbRating(double imdbRating) {
		this.imdbRating = imdbRating;
	}

	@Override
	public String toString() {
		return "MovieDetails [movieId=" + movieId + ", movieTitle=" + movieTitle + ", description=" + description
				+ ", genre=" + genre + ", imdbRating=" + imdbRating + "]";
	}

}
