package com.imdb.adapters;

import com.imdb.core.cases.actor.Actor;
import com.imdb.core.cases.actor.ActorUseCase;
import com.imdb.infra.repository.impl.ActorRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ActorRepositoryGateway implements ActorUseCase {
    private final ActorRepository actorRepository;
    private static ActorRepositoryGateway instance;

    private ActorRepositoryGateway() {
        actorRepository = ActorRepository.getInstance();
    }

    public static ActorRepositoryGateway getInstance() {
        if (Objects.isNull(instance)) {
            instance = new ActorRepositoryGateway();
        }
        return instance;
    }

    @Override
    public void addActor(Actor actor) {
        actorRepository.addActor(actor);
    }

    @Override
    public void removeActor(Actor actor) {
        actorRepository.removeActor(actor);
    }

    @Override
    public Actor updateActor(Actor actor) {
        return actorRepository.updateActor(actor);
    }

    @Override
    public Optional<Actor> searchActor(String name) {
        return actorRepository.searchActor(name);
    }

    @Override
    public List<Actor> getAllActors() {
        return actorRepository.getAllActors();
    }
}
