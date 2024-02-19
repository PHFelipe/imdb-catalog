package com.imdb.infra.elissa;

import java.util.Objects;

public class DirectorRepository extends AbstractRepository {
    private static final ImdbCatalog imdbCatalog = ImdbCatalog.getInstance();

    private static DirectorRepository instance;

    public DirectorRepository() {
        super(imdbCatalog);
    }

    public static DirectorRepository getInstance() {
        if (Objects.isNull(instance)) {
            instance = new DirectorRepository();
        }
        return instance;
    }

    @Override
    protected Class<?> modelClass() {
        return Director.class;
    }
}
