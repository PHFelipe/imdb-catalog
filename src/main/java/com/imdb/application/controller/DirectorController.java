package com.imdb.application.controller;

import com.imdb.application.impl.DirectorUseCaseImpl;

public class DirectorController {
    private final DirectorUseCaseImpl directorUseCaseImpl;

    public DirectorController(DirectorUseCaseImpl directorUseCaseImpl) {
        this.directorUseCaseImpl = directorUseCaseImpl;
    }

    public void deleteDirector(Long id) {
        directorUseCaseImpl.delete(id);
    }
}
