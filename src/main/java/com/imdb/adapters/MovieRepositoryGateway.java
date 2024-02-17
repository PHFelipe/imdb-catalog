package com.imdb.adapters;

import com.imdb.core.cases.movie.MovieUseCase;
import com.imdb.infra.database.ImdbCatalog;
import com.imdb.infra.repository.MovieRepository;

public class MovieRepositoryGateway implements MovieUseCase {
    MovieRepository movieRepository = new MovieRepository(new ImdbCatalog());

    @Override
    public void delete(Long id) {

    }
}
