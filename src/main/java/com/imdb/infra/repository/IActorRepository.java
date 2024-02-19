package com.imdb.infra.repository;

import com.imdb.core.cases.actor.Actor;

import java.util.List;
import java.util.Optional;

public interface IActorRepository {
  void addActor(Actor actor);
  void removeActor(Actor actor);
  Actor updateActor(Actor actor);
  Optional<Actor> searchActor(String name);
  List<Actor> getAllActors();
}
