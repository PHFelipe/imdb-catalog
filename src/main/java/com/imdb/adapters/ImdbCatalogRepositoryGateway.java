package com.imdb.adapters;

import com.imdb.core.cases.actor.Actor;
import com.imdb.core.cases.catalog.ImdbCatalogUseCase;
import com.imdb.core.cases.director.Director;
import com.imdb.core.cases.movie.Movie;
import com.imdb.infra.repository.ActorRepository;
import com.imdb.infra.repository.ImdbCatalogRepository;

import java.util.List;
import java.util.Objects;

public class ImdbCatalogRepositoryGateway implements ImdbCatalogUseCase {
    private static ImdbCatalogRepository imdbCatalogRepository;
    private static ImdbCatalogRepositoryGateway instance;
    private ImdbCatalogRepositoryGateway(){
        imdbCatalogRepository = ImdbCatalogRepository.getInstance();
    }

    public static ImdbCatalogRepositoryGateway getInstance() {
        if (Objects.isNull(instance)) {
            instance = new ImdbCatalogRepositoryGateway();
        }
        return instance;
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
    public void pesquisarFilme(String nameMovie) {

    }
}
