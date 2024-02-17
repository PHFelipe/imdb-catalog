package com.imdb.adapters;

import com.imdb.core.cases.actor.ActorUseCase;
import com.imdb.infra.database.ImdbCatalog;
import com.imdb.infra.repository.ActorRepository;

public class ActorRepositoryGateway implements ActorUseCase {
    ActorRepository actorRepository = new ActorRepository(new ImdbCatalog());

    @Override
    public void delete(Long id) {
        //actorRepository.delete();
    }
}
