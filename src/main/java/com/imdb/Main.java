package com.imdb;

import com.imdb.application.scanner.*;
import com.imdb.infra.database.ImdbCatalog;
import com.imdb.infra.repository.ActorRepository;
import com.imdb.infra.repository.DirectorRepository;
import com.imdb.infra.repository.ImdbCatalogRepository;
import com.imdb.infra.repository.MovieRepository;

public class Main {

    public static void main(String[] args) {
        ImdbCatalog.getInstance();

//        Input input = new Input();
//        int option;
//        do {
//            System.out.println("Digite uma opção");
//            option = input.option();
//            if(option == 1){
//                input.cadastrarFilme();
//            }
//            switch (option) {
//                case 1 -> imdbCatalog.cadastrarFilme();
//                case 2 ->
//                case 3 ->
//            }
//        } while (option != 5);
    }
}