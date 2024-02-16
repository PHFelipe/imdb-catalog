package com.imdb.application.controller;

import com.imdb.application.impl.ActorUseCaseImpl;

public class ActorController {
    private final ActorUseCaseImpl actorUseCaseImpl;

    public ActorController(ActorUseCaseImpl actorUseCaseImpl) {
        this.actorUseCaseImpl = actorUseCaseImpl;
    }

    public void deleteActor(Long id) {
        actorUseCaseImpl.delete(id);
    }
}
