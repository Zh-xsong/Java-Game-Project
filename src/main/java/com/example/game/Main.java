package com.example.game;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      Player player = new Player("PlayerName");
      player.inputPlayerName(scanner);
      player.setPlayerName(player.getPlayerName());
      Game game = new Game(player);

      game.startGame();

      do {
        int guessNumber = scanner.nextInt();
        game.processGuess(guessNumber);
      }while(!game.getGameStatus());
       
        
   
      scanner.close();
    }
}

