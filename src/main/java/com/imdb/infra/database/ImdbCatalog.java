package com.imdb.infra.database;

import com.imdb.core.cases.actor.Actor;
import com.imdb.core.cases.director.Director;
import com.imdb.core.cases.movie.Movie;

import java.util.ArrayList;
import java.util.List;

public class ImdbCatalog {
    private List<Movie> catalog = new ArrayList<>(10);
    private List<Actor> actors = new ArrayList<>(10);
    private List<Director> directors = new ArrayList<>(10);

}
