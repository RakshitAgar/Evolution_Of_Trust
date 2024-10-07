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

    public int getScore() {
        return this.score;
    }

    public void loose() {
        this.score -= 1;
    }

    public void gainThree() {
        this.score += 3;
    }
}
