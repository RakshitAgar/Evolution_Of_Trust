package org.example;

import org.example.Exceptions.InvalidRoundException;

public class Game {
    private Player player1;
    private Player player2;
    private int rounds;

    public Game(Player player1, Player player2, int rounds) {
        if(rounds <= 0){
            throw new InvalidRoundException("Round should be greater than 0");
        }
        this.player1 = player1;
        this.player2 = player2;
        this.rounds = rounds;
    }

    public void playGame() {
        for (int i = 0; i < rounds; i++) {
            player1.playWith(player2);
        }
    }
}
