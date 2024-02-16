package com.imdb.application.controller;

import com.imdb.application.impl.MovieUseCaseImpl;

public class MovieController {
    private final MovieUseCaseImpl movieUseCaseImpl;

    public MovieController(MovieUseCaseImpl movieUseCaseImpl) {
        this.movieUseCaseImpl = movieUseCaseImpl;
    }

    public void deleteMovie(Long id) {
        movieUseCaseImpl.delete(id);
    }
}
