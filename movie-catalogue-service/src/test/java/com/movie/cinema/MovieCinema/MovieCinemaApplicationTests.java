package com.movie.cinema.MovieCinema;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.movie.catalogue.entity.MovieDetails;
import com.movie.catalogue.service.MovieCatalogueServiceInterface;

@RunWith(SpringRunner.class)
@SpringBootTest
//@AutoConfigureMockMvc
class MovieCinemaApplicationTests {

	@MockBean
	private MovieCatalogueServiceInterface movieCatalogueService;

	private static MovieDetails movieDetails;

	@Test
	public void testGetMovieId() {
		MovieDetails movie = new MovieDetails("ie101", "Movie Title", "Description", "Action", 8.0);
		assertEquals("ie101", movie.getMovieId());
	}

	@Test
	public void testSetMovieId() {
		MovieDetails movie = new MovieDetails();
		movie.setMovieId("ie101");
		assertEquals("ie101", movie.getMovieId());
	}

	@Test
	public void testGetMovieTitle() {
		MovieDetails movie = new MovieDetails("ie101", "Movie Title", "Description", "Action", 8.0);
		assertEquals("Movie Title", movie.getMovieTitle());
	}

	@Test
	public void testSetMovieTitle() {
		MovieDetails movie = new MovieDetails();
		movie.setMovieTitle("Movie Title");
		assertEquals("Movie Title", movie.getMovieTitle());
	}

	@Test
	public void testGetDescription() {
		MovieDetails movie = new MovieDetails("ie101", "Movie Title", "Description", "Action", 8.0);
		assertEquals("Description", movie.getDescription());
	}

	@Test
	public void testSetDescription() {
		MovieDetails movie = new MovieDetails();
		movie.setDescription("Description");
		assertEquals("Description", movie.getDescription());
	}

	@Test
	public void testGetGenre() {
		MovieDetails movie = new MovieDetails("ie101", "Movie Title", "Description", "Action", 8.0);
		assertEquals("Action", movie.getGenre());
	}

	@Test
	public void testSetGenre() {
		MovieDetails movie = new MovieDetails();
		movie.setGenre("Action");
		assertEquals("Action", movie.getGenre());
	}

	@Test
	public void testGetImdbRating() {
		MovieDetails movie = new MovieDetails("ie101", "Movie Title", "Description", "Action", 8.0);
		assertEquals(8.0, movie.getImdbRating(), 0.0);
	}

	@Test
	public void testSetImdbRating() {
		MovieDetails movie = new MovieDetails();
		movie.setImdbRating(8.0);
		assertEquals(8.0, movie.getImdbRating(), 0.0);
	}

	@BeforeAll
	public static void setUp() throws Exception {
		movieDetails = new MovieDetails("ie101", "The Shawshank Redemption",
				"Two imprisoned men bond over a number of years...", "Drama", 9.3);
	}

	@Test
	void contextLoads() {
	}

}