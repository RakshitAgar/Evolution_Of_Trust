package org.example;

import org.example.Enums.Move;
import org.example.Enums.PlayerType;

public class Player {
    private int score;
    private PlayerType type;

    public Player(PlayerType type) {
        this.type = type;
        this.score = 0;
    }

    public Move doMove(){
        if(type == PlayerType.ALWAYS_COOPERATE){
            return Move.COOPERATE;
        }else {
            return Move.CHEAT;
        }
    }

    public void addPoints(Move opponentMove) {
        if (doMove() == Move.COOPERATE && opponentMove.equals(Move.COOPERATE)) {
            score += 2;
        } else if (doMove() == Move.CHEAT && opponentMove.equals(Move.CHEAT)) {
            // do nothing since we have to add 0 only
        } else if (doMove() == Move.COOPERATE && opponentMove.equals(Move.CHEAT)){
            score += -1;
        } else {
            score += 3;
        }
    }

    public int getScore() {
        return this.score;
    }
}
