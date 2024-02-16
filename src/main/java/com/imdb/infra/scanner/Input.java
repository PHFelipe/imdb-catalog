package com.imdb.infra.scanner;

import java.util.Scanner;

public class Input {
    Scanner scanner = new Scanner(System.in);

    public int option(){
        return scanner.nextInt();
    }
    public String name(){
        return scanner.nextLine();
    }

}
