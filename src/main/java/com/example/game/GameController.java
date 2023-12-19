package com.example.game;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class GameController {
  
  private Game currentGame;
  private Player currentPlayer;
  @PostMapping("/player")
  public String createPlayer(@RequestParam String name) {
    currentPlayer = new Player(name);
    return "Player " + name + " created";
  }

  @GetMapping("/player")
  public Player getPlayerInfo() {
    return currentPlayer;
  }

  @PostMapping("/game")
  public String startGame() {
    if (currentPlayer == null) {
      return "Please create a player first.";
    }
    currentGame = new Game(currentPlayer);
    String startInfo = currentGame.startGame();
    return startInfo;
  }
    
  @PutMapping("/game")
  public String makeGuess(@RequestParam Integer guess) {
    String guessResult = currentGame.processGuess(guess);
    return guessResult;
  }
      
}