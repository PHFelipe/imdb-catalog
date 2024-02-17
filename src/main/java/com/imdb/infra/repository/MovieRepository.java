package com.imdb.infra.repository;


import com.imdb.core.cases.actor.Actor;
import com.imdb.core.cases.movie.Movie;
import com.imdb.infra.database.ImdbCatalog;

public class MovieRepository  extends AbstractRepository{
    public MovieRepository(ImdbCatalog imdbCatalog) {
        super(imdbCatalog);
    }

    @Override
    protected Class<?> modelClass() {
        return Movie.class;
    }
}
