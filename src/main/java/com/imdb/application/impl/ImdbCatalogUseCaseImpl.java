package com.imdb.application.impl;

import com.imdb.adapters.ImdbCatalogGateway;
import com.imdb.core.cases.actor.Actor;
import com.imdb.core.cases.director.Director;
import com.imdb.core.cases.movie.Movie;
import com.imdb.core.cases.catalog.ImdbCatalogUseCase;

import java.util.List;

public class ImdbCatalogUseCaseImpl implements ImdbCatalogUseCase {

    private final ImdbCatalogGateway imdbCatalogGateway;

    private ImdbCatalogUseCaseImpl(ImdbCatalogGateway imdbCatalogGateway) {
        this.imdbCatalogGateway = imdbCatalogGateway;
    }

    @Override
    public void cadastrarFilme(String name, String dataDeLancamento, String descricao) {

    }

    @Override
    public void cadastrarAtor(Actor actor) {

    }

    @Override
    public void cadastrarDiretor(Director director) {

    }

    @Override
    public void associafilmeComAtoresDiretores(Movie movie, List<Actor> actors, List<Director> directors) {

    }

    @Override
    public void pesquisarFilme(String nameFilme) {
    }
}
