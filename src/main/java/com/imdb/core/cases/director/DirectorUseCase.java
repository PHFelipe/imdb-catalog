package com.imdb.core.cases.director;

import java.util.List;
import java.util.Optional;

public interface DirectorUseCase {
    void addDirector(Director director);

    void removeDirector(Director director);

    Director updateDirector(Director director);

    Optional<Director> searchDirector(String name);

    List<Director> getAllDirectors();
}
