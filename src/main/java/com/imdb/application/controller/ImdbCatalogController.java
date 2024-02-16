package com.imdb.application.controller;

import com.imdb.application.impl.ImdbCatalogUseCaseImpl;
import com.imdb.core.cases.actor.Actor;
import com.imdb.core.cases.director.Director;
import com.imdb.core.cases.movie.Movie;

import java.util.List;

public class ImdbCatalogController {
    private final ImdbCatalogUseCaseImpl imdbCatalogUseCaseImpl;

    public ImdbCatalogController(ImdbCatalogUseCaseImpl imdbCatalogUseCaseImpl) {
        this.imdbCatalogUseCaseImpl = imdbCatalogUseCaseImpl;
    }

    public void cadastrarFilme(Movie movie) {
        imdbCatalogUseCaseImpl.cadastrarFilme(movie);
    }

    public void cadastrarAtor(Actor actor) {
        imdbCatalogUseCaseImpl.cadastrarAtor(actor);
    }

    public void cadastrarDiretor(Director director) {
        imdbCatalogUseCaseImpl.cadastrarDiretor(director);
    }

    public void associafilmeComAtoresDiretores(Movie movie, List<Actor> actors, List<Director> directors) {
        imdbCatalogUseCaseImpl.associafilmeComAtoresDiretores(movie, actors, directors);
    }

    public void pesquisarFilme(String nameFilme) {
        imdbCatalogUseCaseImpl.pesquisarFilme(nameFilme);
    }

}
