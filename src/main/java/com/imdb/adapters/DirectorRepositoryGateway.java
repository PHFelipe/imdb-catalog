package com.imdb.adapters;

import com.imdb.core.cases.director.DirectorUseCase;
import com.imdb.infra.database.ImdbCatalog;
import com.imdb.infra.repository.DirectorRepository;

public class DirectorRepositoryGateway implements DirectorUseCase {
    DirectorRepository directorRepository = new DirectorRepository(new ImdbCatalog());
    @Override
    public void delete(Long id) {

    }
}
