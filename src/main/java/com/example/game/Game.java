package com.example.game;

import java.util.Random;

public class Game implements GameInterface {
  private Player player;
  private Integer secretNumber;
  private Boolean gameStatus;

  public Game(Player player) {
    this.player = player;
    this.gameStatus = false;
  }

  public String startGame() {
    setSecretNumber(getSecretNumber()); 
    player.setGamesPlayed();
    String startInfo = "Welcome to the Game!\n" +
                        "The system will give a random number from 1 to 100.\n" +
                        "And you have 10 chances to guess the secret number.";
    return startInfo;
  }

  public String endGame() {
    return "Game Over!";
  }

  public boolean getGameStatus() {
    return gameStatus;
  }



  public Integer getSecretNumber() {
    Random rand = new Random();
    int upperbound = 100;
    int secretNumber = rand.nextInt(upperbound)+1;
    return secretNumber;
  }

  public void setSecretNumber(Integer secretNumber) {
    this.secretNumber = secretNumber;
  }

  @Override
  public String processGuess(Integer guess) {
    int totalScore = 10;
    player.setGuessTimes();
    int guessTimes = player.getGuessTimes();
    int gameScore = totalScore - guessTimes;
    if (guess.equals(secretNumber)) {
      player.setGameResult("Win!Your game score is: " + gameScore);
      gameStatus = true;
      endGame();
      player.writePlayerInfoToFile("src\\main\\java\\com\\example\\game\\PlayerInfo.txt");
      return ("You win! Your score is: " + gameScore);
    } else {
      if (gameScore <= 0) {
        player.setGameResult("Lose!Maximum guesses reached.");
        gameStatus = true;
        endGame();
        player.writePlayerInfoToFile("src\\main\\java\\com\\example\\game\\PlayerInfo.txt");
        return ("Lose!The secret number was: " + secretNumber);
      } else {
        if (guess < secretNumber) {
          return "The secret number is higher.";
        } else {
          return "The secret number is lower.";
        }
      }
    }
  }
}
