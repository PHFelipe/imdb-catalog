package com.imdb.infra.repository;

import com.imdb.core.cases.movie.Movie;

import java.util.List;
import java.util.Optional;

public interface IMovieRepository {
  void addMovie(Movie movie);
  void removeMovie(Movie movie);
  Movie updateMovie(Movie movie);
  Optional<Movie> searchMovie(String title);
  List<Movie> getAllMovies();
}
