package com.imdb;

import com.imdb.application.scanner.*;

public class Main {

    public static void main(String[] args) {
        Input input = new Input();
        int option;
        do {
            System.out.println("Digite uma opção");
            option = input.option();
            if(option == 1){
                input.cadastrarFilme();
            }
//            switch (option) {
//                case 1 -> imdbCatalog.cadastrarFilme();
//                case 2 ->
//                case 3 ->
//            }
        } while (option != 5);
    }
}