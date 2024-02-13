package com.imdb.controller;

import com.imdb.model.Genre;
import com.imdb.model.Movie;
import com.imdb.repository.MovieRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieController {
  public static void mainMenu() {
    System.out.println("\n----- Menu -----");
    System.out.println("1. Adicionar Filme");
    System.out.println("2. Imprimir Lista de Filmes");
    System.out.println("3. Deletar Filme");
    System.out.println("4. Editar Filme");
    System.out.println("5. Pesquisar Filme");
    System.out.println("0. Sair");
    System.out.print("Escolha uma opção: ");
  }

  public static Movie movieParameter(Scanner sc) {
    System.out.print("Título: ");
    String titulo = sc.nextLine();

    System.out.print("Data de Lançamento (Formato: AAAA-MM-DD): ");
    String dataString = sc.nextLine();
    LocalDate dataLancamento = LocalDate.parse(dataString);

    System.out.print("Orçamento: ");
    double orcamento = sc.nextDouble();
    sc.nextLine(); // Limpar o buffer do scanner

    System.out.print("Sinopse: ");
    String sinopse = sc.nextLine();

    System.out.print("Gênero: ");
    List<Genre> genero = new ArrayList<>();
    genero.add(Genre.valueOf(sc.nextLine()));

    System.out.print("Duração: ");
    int duracao = sc.nextInt();
    sc.nextLine(); // Limpar o buffer do scanner

    System.out.print("Idioma: ");
    String idioma = sc.nextLine();

    return new Movie(
      titulo,
      dataLancamento,
      orcamento,
      sinopse,
      genero,
      duracao,
      idioma
    );
  }

  public static void addMovie(Scanner sc) {
    System.out.println("\n----- Adicionar Filme -----");
    MovieRepository.addMovie(movieParameter(sc));
    System.out.println("Filme adicionado com sucesso!");
  }

  public static void editMovie(Scanner sc) {
    System.out.println("\n----- Editar Filme -----");
    System.out.print(
      "Digite o ID do filme que deseja editar (ou 0 para cancelar): "
    );
    int idFilme = sc.nextInt();
    sc.nextLine(); // Limpar o buffer do scanner

    if (idFilme == 0) {
      System.out.println("Operação de edição cancelada.");
      return;
    }

    MovieRepository
      .searchMovieById(idFilme)
      .ifPresentOrElse(
        movie -> {
          System.out.println(movie);
          System.out.print(
            "Deseja editar este filme? (S para Sim, N para Não): "
          );
          String resposta = sc.nextLine().toUpperCase();
          if ("S".equals(resposta)) {
            MovieRepository.editMovie(idFilme, movieParameter(sc));
            System.out.println("Filme editado com sucesso!");
          } else {
            System.out.println("Edição cancelada.");
          }
        },
        () -> System.out.println("Id não encontrado!")
      );
  }

  public static void removeMovie(Scanner sc) {
    System.out.println("Digite o Id do filme que deseja excluir");
    int id = sc.nextInt();
    sc.nextLine();

    MovieRepository.removeMovie(id);
    System.out.println("Filme removido com sucesso!");
  }

  public static void listAllMovies() {
    List<Movie> movies = MovieRepository.getAllMovies();
    if (movies.isEmpty()) {
      System.out.println("Nenhum filme cadastrado.");
    } else {
      movies.forEach(System.out::println);
    }
  }

  public static void searchMovie(Scanner sc) {
    System.out.println("Digite o Nome, Id ou Gênero");
    String search = sc.nextLine();

    try {
      int searchId = Integer.parseInt(search);
      // Pesquisar por ID
      System.out.println("\nResultados da Busca ID:\n");
      MovieRepository
        .searchMovieById(searchId)
        .ifPresentOrElse(
          System.out::println,
          () ->
            System.out.println(
              "Nenhum filme encontrado com o ID fornecido: " + searchId
            )
        );
    } catch (NumberFormatException e) {
      // Não é um número, então deve ser uma busca por nome ou gênero
      // Pesquisar por Nome
      System.out.println("\nResultados da Busca por Nome:\n");
      MovieRepository
        .searchMovieByName(search)
        .ifPresentOrElse(
          movies -> movies.forEach(System.out::println),
          () ->
            System.out.println(
              "Nenhum filme encontrado com o nome fornecido: " + search
            )
        );

      // Pesquisar por Gênero
      System.out.println("\nResultados da Busca Gênero:\n");
      MovieRepository
        .searchMovieByGenre(search)
        .ifPresentOrElse(
          movies -> movies.forEach(System.out::println),
          () ->
            System.out.println(
              "Nenhum filme encontrado com o gênero fornecido: " + search
            )
        );
    }
  }
}
