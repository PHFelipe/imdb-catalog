package com.imdb.infra.repository;

public class ImdbCatalogRepository  extends AbstractRepository{
    public ImdbCatalogRepository(ImdbCatalog imdbCatalog) {
        super(imdbCatalog);
    }

    @Override
    protected Class modelClass() {
        return ImdbCatalog.class;
    }

}
