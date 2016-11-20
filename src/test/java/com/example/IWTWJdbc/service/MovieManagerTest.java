package com.example.IWTWJdbc.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.example.IWTWJdbc.domain.Movie;
import com.example.IWTWJdbc.domain.Actor;

public class MovieManagerTest {
	
	
	MoviesManager moviesManager = new MoviesManager();
	
	private final static String TITLE_1 = "Inception";
	private final static int RELEASE_1 = 2010;
	private final static String GENRE_1 = "Drama";
	private final static boolean ISFAVORITE_1 = false;
	
	@Test
	public void checkConnection(){
		assertNotNull(moviesManager.getConnection());
	}
	
	@Test
	public void checkAdding(){
		
		Movie movie = new Movie(TITLE_1, RELEASE_1, GENRE_1, ISFAVORITE_1);
		
		moviesManager.clearMovies();
		assertEquals(1,moviesManager.addMovie(movie));
		System.out.println("Movie " + movie.getTitle() + " has been added to database.");
		List<Movie> movies = moviesManager.getAllMovies();
		Movie movieRetrived = movies.get(0);
		
		assertEquals(TITLE_1, movieRetrived.getTitle());
		assertEquals(RELEASE_1, movieRetrived.getReleaseYear());
		assertEquals(GENRE_1, movieRetrived.getGenre());
		assertEquals(ISFAVORITE_1, movieRetrived.getIsFavorite());
		System.out.println("Retrived movie from db id: " + movieRetrived.getId() + " is valid.");
	}
	@Test
	public void checkUpdate()
	{
		List<Movie> movies = moviesManager.getAllMovies();
		Movie movie = movies.get(0);

		String newTitle = "Batman";
		boolean newisFavorite = true;

		System.out.println("Movie before update: " + movie.getId() + " " + movie.getTitle() + " " + movie.getIsFavorite() + ".");

		moviesManager.updateMovie(movie.getId(), newTitle, movie.getReleaseYear(), movie.getGenre(), newisFavorite);
		movies = moviesManager.getAllMovies();
		movie = movies.get(0);
		System.out.println("Movie after update: " + movie.getId() + " " + movie.getTitle() + " " + movie.getIsFavorite() + ".");
		assertEquals(newTitle, movie.getTitle());
		assertEquals(newisFavorite, movie.getIsFavorite());
	}

	@Test
	public void checkDelete()
	{
		List<Movie> movies = moviesManager.getAllMovies();
		Movie movieRetrived = movies.get(0);
		assertEquals(1, moviesManager.deleteMovie(movieRetrived.getId()));
		System.out.println("Movie: " + movieRetrived.getId() + " " + movieRetrived.getTitle() + " has been deleted.");
	}

}
