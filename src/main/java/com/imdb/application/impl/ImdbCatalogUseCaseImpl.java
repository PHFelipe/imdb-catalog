package com.imdb.application.impl;

import com.imdb.adapters.ImdbCatalogGateway;
import com.imdb.core.cases.actor.Actor;
import com.imdb.core.cases.director.Director;
import com.imdb.core.cases.movie.Movie;
import com.imdb.core.cases.catalog.ImdbCatalogUseCase;

import java.util.List;

public class ImdbCatalogUseCaseImpl implements ImdbCatalogUseCase {

    private final ImdbCatalogGateway imdbCatalogGateway;
    public ImdbCatalogUseCaseImpl(ImdbCatalogGateway imdbCatalogGateway) {
        this.imdbCatalogGateway = imdbCatalogGateway;
    }

    @Override
    public void cadastrarFilme(Movie movie) {
        //não recebe filme, mas sim os atributos e cria o new filme aqui
        imdbCatalogGateway.cadastrarFilme(movie);
    }

    @Override
    public void cadastrarAtor(Actor actor) {
        imdbCatalogGateway.cadastrarAtor(actor);
    }

    @Override
    public void cadastrarDiretor(Director director) {
        imdbCatalogGateway.cadastrarDiretor(director);
    }

    @Override
    public void associafilmeComAtoresDiretores(Movie movie, List<Actor> actors, List<Director> directors) {
        imdbCatalogGateway.associafilmeComAtoresDiretores(movie, actors, directors);
    }

    @Override
    public void pesquisarFilme(String nameFilme) {
        imdbCatalogGateway.pesquisarFilme(nameFilme);
    }
}
