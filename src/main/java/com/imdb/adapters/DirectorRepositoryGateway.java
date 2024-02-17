package com.imdb.adapters;

import com.imdb.core.cases.director.DirectorUseCase;
import com.imdb.infra.repository.DirectorRepository;

import java.util.Objects;

public class DirectorRepositoryGateway implements DirectorUseCase {
    private static DirectorRepository directorRepository;
    private static DirectorRepositoryGateway instance;
    private DirectorRepositoryGateway(){
        directorRepository = DirectorRepository.getInstance();
    }

    public static DirectorRepositoryGateway getInstance() {
        if (Objects.isNull(instance)) {
            instance = new DirectorRepositoryGateway();
        }
        return instance;
    }

    @Override
    public void delete(Long id) {

    }
}
