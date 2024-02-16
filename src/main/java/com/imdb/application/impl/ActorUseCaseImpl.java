package com.imdb.application.impl;

import com.imdb.adapters.ActorGateway;
import com.imdb.core.cases.actor.ActorUseCase;

public class ActorUseCaseImpl implements ActorUseCase {

    private final ActorGateway actorGateway;

    public ActorUseCaseImpl(ActorGateway actorGateway) {
        this.actorGateway = actorGateway;
    }

    @Override
    public void delete(Long id) {
        actorGateway.deleteActor(id);
    }
}
