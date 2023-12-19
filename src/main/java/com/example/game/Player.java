package com.example.game;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Player implements PlayerInterface {
  private String playerName;
  private Integer gamesPlayed;
  private Integer guessTimes;
  private String result;

  public Player(String playerName) {
    this.playerName = playerName;
    this.gamesPlayed = 0;
    this.guessTimes = 0;
    this.result = "You haven't played the game yet";
  }

  @Override
  public String getPlayerName() {
    return playerName;
  }

  public void setPlayerName(String playerName) {
    this.playerName = playerName;
  }

  public void inputPlayerName(Scanner scanner) {
    System.out.println("Please enter your username:");
    String name = scanner.nextLine();
    setPlayerName(name);
  }


  public void setGamesPlayed() {
    this.gamesPlayed++;
  }

  
  public Integer getGamesPlayed() {
    return this.gamesPlayed;
  }

  public void setGuessTimes() {
    this.guessTimes++;
  }

  public Integer getGuessTimes() {
    return this.guessTimes;
  }

  public void setGameResult(String result) {
    this.result = result;
  }

  public String getGameResults() {
    return this.result;
  }

  public void writePlayerInfoToFile(String filePath) {
     File file = new File(filePath);
     FileWriter fileWriter = null;
     try {
      fileWriter = new FileWriter(file, true);
      String playerData = "Player Name: " + getPlayerName() + "\n"
                          + "games Played: " + getGamesPlayed() + "\n"
                          + "Guess Times: " + getGuessTimes() + "\n"
                          + "Game Result: " + getGameResults() + "\n";
      fileWriter.write(playerData);
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
       try {
        if (fileWriter != null) {
          fileWriter.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

}