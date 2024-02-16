package com.imdb.application.impl;

import com.imdb.adapters.DirectorGateway;
import com.imdb.core.cases.director.DirectorUseCase;

public class DirectorUseCaseImpl implements DirectorUseCase {

    private final DirectorGateway directorGateway;

    public DirectorUseCaseImpl(DirectorGateway directorGateway) {
        this.directorGateway = directorGateway;
    }

    @Override
    public void delete(Long id) {
        directorGateway.deleteDirector(id);
    }
}
