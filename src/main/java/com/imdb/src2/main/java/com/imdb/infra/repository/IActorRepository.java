package com.imdb.src2.main.java.com.imdb.infra.repository;

import com.imdb.model.Actor;

import java.util.List;
import java.util.Optional;

public interface IActorRepository {
  void addActor(Actor actor);
  void removeActor(Actor actor);
  Actor updateActor(Actor actor);
  Optional<Actor> searchActor(String name);
  List<Actor> getAllActors();
}
