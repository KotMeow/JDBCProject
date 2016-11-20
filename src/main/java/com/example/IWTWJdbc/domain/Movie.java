package com.example.IWTWJdbc.domain;

public class Movie {

	private int id;
    private String title;
    private int releaseYear;
    private String genre;
    private boolean isFavorite = false;


    public Movie() {
        super();
    }


    public Movie(String title, int releaseYear, String genre, boolean isFavorite) {
        super();
        this.title = title;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.isFavorite = isFavorite;
    }


    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }


    public boolean getIsFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(boolean isFavorite) {
        this.isFavorite = isFavorite;
    }
}
