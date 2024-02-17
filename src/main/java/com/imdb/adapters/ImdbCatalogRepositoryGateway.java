package com.imdb.adapters;

import com.imdb.core.cases.actor.Actor;
import com.imdb.core.cases.catalog.ImdbCatalogUseCase;
import com.imdb.core.cases.director.Director;
import com.imdb.core.cases.movie.Movie;
import com.imdb.infra.database.ImdbCatalog;
import com.imdb.infra.repository.ImdbCatalogRepository;

import java.util.List;

public class ImdbCatalogRepositoryGateway implements ImdbCatalogUseCase {
    ImdbCatalogRepository imdbCatalogRepository = new ImdbCatalogRepository(new ImdbCatalog());
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
    public void pesquisarFilme(String nameMovie) {

    }
}
