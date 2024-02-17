package com.imdb.infra.repository;

import com.imdb.infra.database.ImdbCatalog;

import java.util.Collections;
import java.util.List;

public abstract class AbstractRepository {
    // Referência ao catálogo do IMDB
    private final ImdbCatalog imdbCatalog;

    // Construtor que recebe o catálogo do IMDB como parâmetro
    public AbstractRepository(ImdbCatalog imdbCatalog) {
        this.imdbCatalog = imdbCatalog;
    }

    // Método para adicionar um objeto ao catálogo
    public void create(Object objeto) {
        this.imdbCatalog.create(objeto);
    }

    // Método para obter uma lista de objetos do catálogo
    public List getList() {
        // Obtém a lista de objetos da classe do repositório
        List<Object> getObjects = this.imdbCatalog.getObjectByType(modelClass());
        // Retorna uma lista não modificável dos objetos
        return Collections.unmodifiableList(getObjects);
    }

    // Método para excluir um objeto do catálogo
    public Boolean delete(Object objeto) {
        // Remove o objeto do catálogo
        this.imdbCatalog.delete(objeto);
        // Retorna verdadeiro indicando sucesso na exclusão
        return true;
    }

    // Método abstrato para obter a classe do modelo
    protected abstract Class modelClass();
}
