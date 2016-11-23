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

	private final static String NAME_1 = "Leonardo DiCaprio";
	private final static String ROLE_1 = "Bear";
	
	@Test
	public void checkConnection(){
		assertNotNull(moviesManager.getConnection());
	}
	
	@Test
	public void checkAdding(){

		System.out.println("######### ADDING TEST START #########\n");

		Movie movie = new Movie(TITLE_1, RELEASE_1, GENRE_1, ISFAVORITE_1);
		moviesManager.clearActors();
		moviesManager.clearMovies();
		//moviesManager.clearActors();
		assertEquals(1,moviesManager.addMovie(movie));

		System.out.println("Movie " + movie.getTitle() + " has been added to database.");

		List<Movie> movies = moviesManager.getAllMovies();
		Movie movieRetrived = movies.get(0);

		assertEquals(TITLE_1, movieRetrived.getTitle());
		assertEquals(RELEASE_1, movieRetrived.getReleaseYear());
		assertEquals(GENRE_1, movieRetrived.getGenre());
		assertEquals(ISFAVORITE_1, movieRetrived.getIsFavorite());
		System.out.println("Retrived movie from db id: " + movieRetrived.getId() + " is valid.");
		System.out.println("######### ADDING TEST FINISH #########\n");
	}

	@Test
	public void checkActorAdding(){

		System.out.println("######### ACTOR ADDING TEST START #########\n");
		int movieid = moviesManager.getAllMovies().get(0).getId();
		Actor actor = new Actor(NAME_1,ROLE_1);
		assertEquals(1,moviesManager.addActor(movieid,actor));
		System.out.println("Actor " + actor.getName() + " has been added to database.");
		List<Actor> actors = moviesManager.getAllActors();
		Actor actorRetrived = actors.get(0);

		assertEquals(NAME_1, actorRetrived.getName());
		assertEquals(ROLE_1, actorRetrived.getRole());
		System.out.println("######### ACTOR ADDING TEST FINISH #########\n");
	}
	@Test
	public void checkUpdate()
	{
		System.out.println("######### UPDATE TEST START #########\n");
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
		System.out.println("######### ADDING TEST FINISH #########\n");
	}

	@Test
	public void checkActorDelete(){
		System.out.println("######### DELETE TEST START #########\n");
		List<Actor> actors = moviesManager.getAllActors();
		Actor actorRetrived = actors.get(0);
		assertEquals(1, moviesManager.deleteActor(actorRetrived.getId()));
		System.out.println("Actor: " + actorRetrived.getId() + " has been deleted.");
		System.out.println("######### DELETE TEST FINISH #########\n");
	}

	@Test
	public void checkDelete(){
		System.out.println("######### DELETE TEST START #########\n");
		List<Movie> movies = moviesManager.getAllMovies();
		Movie movieRetrived = movies.get(0);
		assertEquals(1, moviesManager.deleteMovie(movieRetrived.getId()));
		System.out.println("Movie: " + movieRetrived.getId() + " " + movieRetrived.getTitle() + " has been deleted.");
		System.out.println("######### DELETE TEST FINISH #########\n");
	}

}
