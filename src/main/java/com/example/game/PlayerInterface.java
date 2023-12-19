package com.example.game;

public interface PlayerInterface {

  String getPlayerName();
  void setPlayerName(String name);

  Integer getGamesPlayed();
  void setGamesPlayed(); 


  Integer getGuessTimes();
  void setGuessTimes();

  String getGameResults();
  void setGameResult(String result);
  
}