package com.imdb.infra.repository;

import com.imdb.adapters.ImdbCatalogGateway;
import com.imdb.core.cases.actor.Actor;
import com.imdb.core.cases.director.Director;
import com.imdb.core.cases.movie.Movie;

import java.util.List;

public class ImdbCatalogRepository implements ImdbCatalogGateway {
    @Override
    public void cadastrarFilme(Movie movie) {

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
