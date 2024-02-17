package com.imdb.infra.repository;

import com.imdb.core.cases.director.Director;

public class DirectorRepository extends AbstractRepository {

    public DirectorRepository(ImdbCatalog imdbCatalog) {
        super(imdbCatalog);
    }

    @Override
    protected Class modelClass() {
        return Director.class;
    }
}
