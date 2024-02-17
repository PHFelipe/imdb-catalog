package com.imdb.infra.repository;

import com.imdb.core.cases.actor.Actor;
import com.imdb.infra.database.ImdbCatalog;

public class ImdbCatalogRepository  extends AbstractRepository{
    public ImdbCatalogRepository(ImdbCatalog imdbCatalog) {
        super(imdbCatalog);
    }

    @Override
    protected Class<?> modelClass() {
        return ImdbCatalog.class;
    }

}
