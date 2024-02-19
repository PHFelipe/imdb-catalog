package com.imdb.adapters;

import com.imdb.core.cases.director.Director;
import com.imdb.core.cases.director.DirectorUseCase;
import com.imdb.infra.repository.impl.DirectorRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class DirectorRepositoryGateway implements DirectorUseCase {
    private final DirectorRepository directorRepository;
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
    public void addDirector(Director director) {
        directorRepository.addDirector(director);
    }

    @Override
    public void removeDirector(Director director) {
        directorRepository.removeDirector(director);
    }

    @Override
    public Director updateDirector(Director director) {
        return directorRepository.updateDirector(director);
    }

    @Override
    public Optional<Director> searchDirector(String name) {
        return directorRepository.searchDirector(name);
    }

    @Override
    public List<Director> getAllDirectors() {
        return directorRepository.getAllDirectors();
    }
}
