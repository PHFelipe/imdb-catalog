package com.imdb.core.cases.movie;

import java.util.List;
import java.util.Optional;

public interface MovieUseCase {
    void addMovie(Movie movie);

    void removeMovie(Movie movie);

    Movie updateMovie(Movie movie);

    Optional<Movie> searchMovie(String Title);

    Optional<Movie> searchMovieById(int id);

    List<Movie> getAllMovies();
}
