package com.imdb.application.impl;

import com.imdb.adapters.DirectorRepositoryGateway;
import com.imdb.core.cases.director.DirectorUseCase;

public class DirectorUseCaseImpl implements DirectorUseCase {
    private final DirectorRepositoryGateway directorGateway = new DirectorRepositoryGateway();

    @Override
    public void delete(Long id) {
        directorGateway.delete(id);
    }
}
