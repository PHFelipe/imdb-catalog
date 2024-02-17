package com.imdb.controller;

import com.imdb.appServices.ActorService;
import com.imdb.appServices.DirectorService;
import com.imdb.appServices.MovieService;
import com.imdb.model.Actor;
import com.imdb.model.Director;
import com.imdb.model.Movie;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MovieController {

  private final MovieService movieService;
  private final ActorService actorService;
  private final DirectorService directorService;
  private final Scanner scanner;

  public MovieController(MovieService movieService, ActorService actorService, DirectorService directorService, Scanner scanner) {
    this.movieService = movieService;
    this.actorService = actorService;
    this.directorService = directorService;
    this.scanner = scanner;
  }

  public void registerNewMovie(){
    System.out.print("Enter the name of the movie: ");
    String name = scanner.nextLine();

    Movie existingMovie = movieService.getMovieByName(name);

    if (existingMovie != null) {
      System.out.println("This movie title already exists.");
      System.out.print("Do you want to edit it? (Yes or No): ");
      String editChoice = scanner.nextLine();
      if (editChoice.equalsIgnoreCase("Yes")) {
        editMovie();
      }
      return;
    }

    String title = name;
    int releaseDate = enterReleaseDate();
    double budget = enterBudget();
    String currency = enterCurrency();
    String description = enterDescription();
    List<Actor> actors = enterActors();
    List<Director> directors = enterDirectors();

    Movie newMovie = new Movie(title, releaseDate, budget, currency, description, actors, directors);
    movieService.addMovie(newMovie);

    System.out.print("Do you want to add a new movie? (Yes or No): ");
    if (scanner.nextLine().equalsIgnoreCase("Yes")) {
      registerNewMovie();
    } else {
      System.out.println("Returning to main menu...");
    }
  }


  public void showListOfMovies() {
    List<Movie> movies = movieService.getAllMovies();
    if (movies.isEmpty()) {
      System.out.println("No movies available.");
      return;
    }

    System.out.println("Movies List:");
    movies.forEach(movie ->
      System.out.println("ID " + movie.getId() + ": " + movie.getTitle())
    );
    System.out.println(
      "Choose a movie ID to show all movie details or enter 0 to return:"
    );

    int movieId = safeNextInt();
    if (movieId == 0) return;

    Movie selectedMovie = MovieService.searchMovie(movieId);
    if (selectedMovie == null) {
      System.out.println("Movie with ID " + movieId + " not found.");
      return;
    }
    printMovieDetails(selectedMovie);
  }

  private void printMovieDetails(Movie selectedMovie) {
    System.out.println("Movie title: " + selectedMovie.getTitle());
    System.out.println("Release Date: " + selectedMovie.getReleaseDate());
    System.out.println(
      "Budget: " + selectedMovie.getBudget() + " " + selectedMovie.getCurrency()
    );
    System.out.println("Description: " + selectedMovie.getDescription());
    System.out.println("List of Actors: ");
    List<Actor> actors = selectedMovie.getActors();
    for (int i = 0; i < actors.size(); i++) {
      System.out.println(
        (i + 1) +
        " - " +
        actors.get(i).getName() +
        "\t" +
        actors.get(i).getNationality()
      );
    }
    System.out.println("List of Directors: ");
    List<Director> directors = selectedMovie.getDirectors();
    for (int i = 0; i < directors.size(); i++) {
      System.out.println(
        (i + 1) +
        " - " +
        directors.get(i).getName() +
        "\t" +
        directors.get(i).getNationality()
      );
    }

    System.out.print("Do you want to edit this movie? (Yes or No): ");
    String editChoice = scanner.nextLine();
    if (editChoice.equalsIgnoreCase("Yes")) {
      editMovie();
    } else {
      System.out.println("Returning to the main menu...");
    }
  }

  private int enterReleaseDate() {
    System.out.print(
      "Enter Movie Release Date (Year of release that must accept a number with only 4 digits and must not start with 0): "
    );
    while (true) {
      try {
        int releaseDate = Integer.parseInt(scanner.nextLine());
        if (String.valueOf(releaseDate).length() != 4) {
          throw new IllegalArgumentException(
            "The year of release must contain only 4 digits. Type it again!"
          );
        } else if (String.valueOf(releaseDate).startsWith("0")) {
          throw new IllegalArgumentException(
            "Release year must not start with 0. Enter again!"
          );
        }
        return releaseDate;
      } catch (NumberFormatException e) {
        System.out.println(
          "The year of release must not contain letters. Type it again!"
        );
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
      }
    }
  }

  private String enterCurrency() {
    System.out.println(
      "Enter the movie Budget. Will it be in Euro, Dollar or Real?"
    );
    System.out.println("1 - Euro");
    System.out.println("2 - Dollar");
    System.out.println("3 - Real");
    System.out.print("Enter your choice: ");
    while (true) {
      try {
        int currencyChoice = Integer.parseInt(scanner.nextLine());
        return switch (currencyChoice) {
          case 1 -> "Euro";
          case 2 -> "Dollar";
          case 3 -> "Real";
          default -> throw new IllegalArgumentException(
            "This currency does not exist. Enter a number from 1 to 3."
          );
        };
      } catch (NumberFormatException e) {
        System.out.println("Invalid input. Please enter a number.");
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
      }
    }
  }

  private String enterDescription() {
    System.out.print(
      "Enter the description of the movie (must not exceed 500 words): "
    );
    while (true) {
      String description = scanner.nextLine();
      if (description.length() > 500) {
        System.out.println(
          "The description cannot exceed 500 words. Type it again!"
        );
      } else {
        return description;
      }
    }
  }

  private List<Actor> enterActors() {
    List<Actor> actors = new ArrayList<>();
    int numberOfActors;
    while (true) {
      System.out.print(
        "How many actors do you want to add? (It will not be possible to add more than 15 actors): "
      );
      try {
        numberOfActors = Integer.parseInt(scanner.nextLine());
        if (numberOfActors < 1 || numberOfActors > 15) {
          throw new IllegalArgumentException("You can enter up to 15 actors.");
        }
        break;
      } catch (NumberFormatException e) {
        System.out.println("Invalid input. Please enter a number.");
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
      }
    }

    for (int i = 1; i <= numberOfActors; i++) {
      System.out.print("Enter the name of actor " + i + ": ");
      String actorName = scanner.nextLine();
      Actor existingActor = actorService.getActorByName(actorName);
      String nationality;
      if (existingActor != null) {
        System.out.println("Actor already exists.");
      } else {
        System.out.print("Add nationality: ");
        nationality = scanner.nextLine();
        existingActor = new Actor(0, actorName, nationality);
        actorService.addActor(existingActor);
      }
      actors.add(existingActor);
    }
    return actors;
  }

  private List<Director> enterDirectors() {
    List<Director> directors = new ArrayList<>();
    int numberOfDirectors;
    while (true) {
      System.out.print(
        "How many directors do you want to add? (It will not be possible to add more than 10 directors): "
      );
      try {
        numberOfDirectors = Integer.parseInt(scanner.nextLine());
        if (numberOfDirectors < 1 || numberOfDirectors > 10) {
          throw new IllegalArgumentException(
            "You can enter up to 10 directors."
          );
        }
        break;
      } catch (NumberFormatException e) {
        System.out.println("Invalid input. Please enter a number.");
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
      }
    }

    for (int i = 1; i <= numberOfDirectors; i++) {
      System.out.print("Enter the name of director " + i + ": ");
      String directorName = scanner.nextLine();
      Director existingDirector = directorService.getDirectorByName(
        directorName
      );
      String nationality;
      if (existingDirector != null) {
        System.out.println("Director already exists.");
      } else {
        System.out.print("Add nationality: ");
        nationality = scanner.nextLine();
        existingDirector = new Director(0, directorName, nationality);
        directorService.addDirector(existingDirector);
      }
      directors.add(existingDirector);
    }
    return directors;
  }

  public void editMovie() {
    System.out.println("Which movie do you want to edit?");
    int movieIdToEdit = scanner.nextInt();
    scanner.nextLine();

    Movie movieToEdit = MovieService.searchMovie(movieIdToEdit);
    if (movieToEdit != null) {
      System.out.println("Editing movie: " + movieToEdit.getTitle());
      System.out.println("What would you like to edit?");
      System.out.println("1. Title");
      System.out.println("2. Release Date");
      System.out.println("3. Budget");
      System.out.println("4. Description");
      System.out.println("5. Actors");
      System.out.println("6. Directors");
      System.out.println("7. Cancel");
      System.out.print("Enter your choice: ");

      int choice = safeNextInt();
      switch (choice) {
        case 1:
          editTitle(movieToEdit);
          break;
        case 2:
          editReleaseDate(movieToEdit);
          break;
        case 3:
          editBudget(movieToEdit);
          break;
        case 4:
          editDescription(movieToEdit);
          break;
        case 5:
          actorService.editActor(movieToEdit);
          break;
        case 6:
          directorService.editDirector(movieToEdit);
          break;
        case 7:
          System.out.println("Cancelling movie edit.");
          break;
        default:
          System.out.println("Invalid choice.");
          break;
      }
    } else {
      System.out.println("Movie with ID " + movieIdToEdit + " not found.");
    }
  }

  public void editTitle(Movie movie) {
    System.out.print("Enter the new title: ");
    String newTitle = scanner.nextLine();
    movie.setTitle(newTitle);
    System.out.println("Title updated successfully!");
  }

  public void editReleaseDate(Movie movie) {
    System.out.print("Enter the new release date: ");
    int newReleaseDate = scanner.nextInt();
    scanner.nextLine();
    movie.setReleaseDate(newReleaseDate);
    System.out.println("Release date updated successfully!");
  }

  public void editBudget(Movie movie) {
    System.out.print("Enter the new budget: ");
    double newBudget = scanner.nextDouble();
    scanner.nextLine();
    movie.setBudget(newBudget);
    System.out.println("Budget updated successfully!");
  }

  public void editDescription(Movie movie) {
    System.out.print("Enter the new description: ");
    String newDescription = scanner.nextLine();
    movie.setDescription(newDescription);
    System.out.println("Description updated successfully!");
  }

  public void deleteMovie() {
    List<Movie> movies = movieService.getAllMovies();
    if (movies.isEmpty()) {
      System.out.println("No movies available for deletion.");
      return;
    }

    System.out.println("Movie List:");
    for (Movie movie : movies) {
      System.out.println("ID " + movie.getId() + ": " + movie.getTitle());
    }

    System.out.print("Enter the ID of the movie you want to delete: ");
    int movieIdToDelete = scanner.nextInt();
    scanner.nextLine();

    movieService.removeMovie(movieIdToDelete);
  }

  private int safeNextInt() {
    while (true) {
      try {
        return scanner.nextInt();
      } catch (InputMismatchException e) {
        scanner.nextLine();
        System.out.println("Invalid input. Please enter a valid number.");
      }
    }
  }

  public void searchMovie() {
    System.out.println("Menu - Search");
    System.out.println(
      "Do you want to search for a Movie Title, Actor, Director or Release Date?"
    );
    System.out.println("1 - Movie Title");
    System.out.println("2 - Actor");
    System.out.println("3 - Director");
    System.out.println("4 - Release Date");
    System.out.print("Enter your choice: ");
    int searchChoice = scanner.nextInt();
    scanner.nextLine();

    switch (searchChoice) {
      case 1:
        searchByTitle();
        break;
      case 2:
        searchByActor();
        break;
      case 3:
        searchByDirector();
        break;
      case 4:
        searchByReleaseDate();
        break;
      default:
        System.out.println("Invalid choice. Returning to main menu...");
    }
  }

  private void searchByTitle() {
    System.out.print("What is the title of the movie you want to search for? ");
    String title = scanner.nextLine();
    ArrayList<Movie> foundMovies = new ArrayList<>();
    for (Movie movie : movieService.getAllMovies()) {
      if (movie.getTitle().equalsIgnoreCase(title)) {
        foundMovies.add(movie);
      }
    }
    displayMovieTitleSearchResult(foundMovies);
  }

  private void displayMovieTitleSearchResult(List<Movie> movies) {
    if (movies.isEmpty()) {
      System.out.println("No movies found.");
    } else {
      for (Movie movie : movies) {
        System.out.println("Movie title: " + movie.getTitle());
        System.out.println("Release Date: " + movie.getReleaseDate());
        System.out.println(
          "Budget: " + movie.getBudget() + " " + movie.getCurrency()
        );
        System.out.println("Description: " + movie.getDescription());
        System.out.println("List of Actors:");
        for (Actor actor : movie.getActors()) {
          System.out.println(actor.getName());
        }
        System.out.println("List of Directors:");
        for (Director director : movie.getDirectors()) {
          System.out.println(director.getName());
        }
        System.out.println(
          "Do you want to look for another movie? (Yes or No): "
        );
        String choice = scanner.nextLine();
        if (!choice.equalsIgnoreCase("Yes")) {
          System.out.println("Returning to the main menu...");
          break;
        }
      }
    }
  }

  private void searchByActor() {
    System.out.print("Which actor do you want to look for? ");
    String actorName = scanner.nextLine();
    List<Movie> foundMovies = new ArrayList<>();
    for (Movie movie : movieService.getAllMovies()) {
      for (Actor actor : movie.getActors()) {
        if (actor.getName().equalsIgnoreCase(actorName)) {
          foundMovies.add(movie);
          break;
        }
      }
    }
    displayActorSearchResult(foundMovies);
  }

  public void searchByDirector() {
    System.out.print("Which director do you want to look for? ");
    String directorName = scanner.nextLine();
    Director director = directorService.getDirectorByName(directorName);
    if (director == null) {
      System.out.println("Director not found.");
      return;
    }
    searchByDirector(movieService.getAllMovies(), director);
  }

  private void searchByDirector(List<Movie> allMovies, Director director) {
    List<Movie> foundMovies = new ArrayList<>();
    for (Movie movie : allMovies) {
      for (Director dir : movie.getDirectors()) {
        if (dir.getName().equalsIgnoreCase(director.getName())) {
          foundMovies.add(movie);
          break;
        }
      }
    }
    displayDirectorSearchResult(foundMovies);
  }

  private void searchByReleaseDate() {
    System.out.print("What release year are you looking for? ");
    String releaseDate = scanner.nextLine();
    List<Movie> foundMovies = new ArrayList<>();
    for (Movie movie : movieService.getAllMovies()) {
      if (String.valueOf(movie.getReleaseDate()).equals(releaseDate)) {
        foundMovies.add(movie);
      }
    }
    displayReleaseDateSearchResult(foundMovies);
  }

  private void displayActorSearchResult(List<Movie> movies) {
    if (movies.isEmpty()) {
      System.out.println("No movies found for this actor.");
    } else {
      for (Movie movie : movies) {
        System.out.println(
          "Movie title: " +
          movie.getTitle() +
          "\tRelease Date: " +
          movie.getReleaseDate()
        );
      }
      System.out.println(
        "Do you want to see more details about any movie on the list? (Yes or No): "
      );
      String choice = scanner.nextLine();
      if (choice.equalsIgnoreCase("Yes")) {
        System.out.print("Enter the movie ID: ");
        int movieId = scanner.nextInt();
        scanner.nextLine();
        ArrayList<Movie> aux = new ArrayList<>();
        aux.add(MovieService.searchMovie(movieId));
        displayMovieTitleSearchResult(aux);
      } else {
        System.out.println("Returning to the main menu...");
      }
    }
  }

  private void displayDirectorSearchResult(List<Movie> movies) {
    if (movies.isEmpty()) {
      System.out.println("No movies found for this director.");
    } else {
      for (Movie movie : movies) {
        System.out.println(
          "Movie title: " +
          movie.getTitle() +
          "\tRelease Date: " +
          movie.getReleaseDate()
        );
      }
      System.out.println(
        "Do you want to see more details about any movie on the list? (Yes or No): "
      );
      String choice = scanner.nextLine();
      if (choice.equalsIgnoreCase("Yes")) {
        System.out.print("Enter the movie ID: ");
        int movieId = scanner.nextInt();
        scanner.nextLine();
        Movie selectedMovie = MovieService.searchMovie(movieId);
        if (selectedMovie != null) {
          printMovieDetails(selectedMovie);
        } else {
          System.out.println("Movie with ID " + movieId + " not found.");
        }
      } else {
        System.out.println("Returning to the main menu...");
      }
    }
  }

  private void displayReleaseDateSearchResult(List<Movie> movies) {
    if (movies.isEmpty()) {
      System.out.println("No movies found for this release year.");
    } else {
      for (Movie movie : movies) {
        System.out.println("Movie title: " + movie.getTitle());
      }
      System.out.println(
        "Do you want to see more details about any movie on the list? (Yes or No): "
      );
      String choice = scanner.nextLine();
      if (choice.equalsIgnoreCase("Yes")) {
        System.out.print("Enter the movie ID: ");
        int movieId = scanner.nextInt();
        scanner.nextLine();
        ArrayList<Movie> aux = new ArrayList<>();
        aux.add(MovieService.searchMovie(movieId));
        displayMovieTitleSearchResult(aux);
      } else {
        System.out.println("Returning to the main menu...");
      }
    }
  }
}
