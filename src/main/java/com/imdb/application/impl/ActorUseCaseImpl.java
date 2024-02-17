package com.imdb.application.impl;

import com.imdb.adapters.ActorRepositoryGateway;
import com.imdb.core.cases.actor.ActorUseCase;

public class ActorUseCaseImpl implements ActorUseCase {
    private final ActorRepositoryGateway actorGateway = new ActorRepositoryGateway();

    @Override
    public void delete(Long id) {
        actorGateway.delete(id);
    }
}
