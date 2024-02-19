package com.imdb.core.cases.actor;

import java.util.List;
import java.util.Optional;

public interface ActorUseCase {
    void addActor(Actor actor);

    void removeActor(Actor actor);

    Actor updateActor(Actor actor);

    Optional<Actor> searchActor(String name);

    List<Actor> getAllActors();
}
