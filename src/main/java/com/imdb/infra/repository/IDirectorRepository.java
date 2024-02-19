package com.imdb.infra.repository;

import com.imdb.core.cases.director.Director;

import java.util.List;
import java.util.Optional;

public interface IDirectorRepository {
  void addDirector(Director director);
  void removeDirector(Director director);
  Director updateDirector(Director director);
  Optional<Director> searchDirector(String name);
  List<Director> getAllDirectors();
}
