package com.example.game;

public interface GameInterface {
  String startGame(); 

  String endGame(String msg); 

  Integer getSecretNumber();
  void setSecretNumber(Integer secretNumber);

  String processGuess(Integer guess);
}
