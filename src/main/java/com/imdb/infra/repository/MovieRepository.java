package com.imdb.infra.repository;


import com.imdb.core.cases.movie.Movie;

public class MovieRepository  extends AbstractRepository{
    public MovieRepository(ImdbCatalog imdbCatalog) {
        super(imdbCatalog);
    }

    @Override
    protected Class modelClass() {
        return Movie.class;
    }
}
