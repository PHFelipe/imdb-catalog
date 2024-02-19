package com.imdb.adapters;

import com.imdb.core.cases.movie.Movie;
import com.imdb.core.cases.movie.MovieUseCase;
import com.imdb.infra.repository.impl.MovieRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class MovieRepositoryGateway implements MovieUseCase {
    private final  MovieRepository movieRepository;
    private static MovieRepositoryGateway instance;
    private MovieRepositoryGateway(){
        movieRepository = MovieRepository.getInstance();
    }

    public static MovieRepositoryGateway getInstance() {
        if (Objects.isNull(instance)) {
            instance = new MovieRepositoryGateway();
        }
        return instance;
    }

    @Override
    public void addMovie(Movie movie) {
        movieRepository.addMovie(movie);
    }

    @Override
    public void removeMovie(Movie movie) {
        movieRepository.removeMovie(movie);
    }

    @Override
    public Movie updateMovie(Movie movie) {
        return movieRepository.updateMovie(movie);
    }

    @Override
    public Optional<Movie> searchMovie(String Title) {
        return movieRepository.searchMovie(Title);
    }

    @Override
    public Optional<Movie> searchMovieById(int id) {
        return getAllMovies()
                .stream()
                .filter(movie -> movie.getId() == id)
                .findFirst();
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.getAllMovies();
    }
}
