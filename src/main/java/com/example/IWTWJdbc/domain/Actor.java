package com.example.IWTWJdbc.domain;

public class Actor {

	private int id;
    private String name;
    private String role;
    private int MovieId;

    public Actor(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getMovieId() {
		return MovieId;
	}
	public void setMovieId(int id) {
		this.MovieId = id;
	}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}