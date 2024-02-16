package com.imdb.application.impl;

import com.imdb.adapters.MovieGateway;
import com.imdb.core.cases.movie.MovieUseCase;

public class MovieUseCaseImpl implements MovieUseCase {

    private final MovieGateway movieGateway;

    public MovieUseCaseImpl(MovieGateway movieGateway) {
        this.movieGateway = movieGateway;
    }

    @Override
    public void delete(Long id) {
        movieGateway.deleteMovie(id);
    }
}
