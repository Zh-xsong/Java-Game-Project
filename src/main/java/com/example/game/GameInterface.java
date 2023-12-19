package com.example.game;

public interface GameInterface {
  String startGame(); 

  String endGame(); 

  Integer getSecretNumber();
  void setSecretNumber(Integer secretNumber);

  String processGuess(Integer guess);
}
