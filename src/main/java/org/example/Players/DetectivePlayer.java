package org.example.Players;

import org.example.Enums.Move;
import org.example.Player;

public class DetectivePlayer extends Player {
    private int moveCount;
    private boolean opponentCheated;
    private Move lastOpponentMove;

    public DetectivePlayer() {
        this.moveCount = 0;
        this.opponentCheated = false;
        this.lastOpponentMove = null;
    }

    @Override
    public Move doMove() {
       moveCount++;

        if (moveCount == 1) return Move.COOPERATE;
        if (moveCount == 2) return Move.CHEAT;
        if (moveCount == 3) return Move.COOPERATE;
        if (moveCount == 4) return Move.COOPERATE;

        if(opponentCheated){
            // opponent Cheated the player
            return lastOpponentMove;
        } else {
            // opponent never cheated
            return Move.CHEAT;
        }
    }

    @Override
    public void rememberMove(Move opponentMove) {
        if (opponentMove == Move.CHEAT) {
            opponentCheated = true;
        }

        // Let CopyCat remember opponent's moves if necessary
        if (opponentCheated) {
            this.lastOpponentMove = opponentMove;
        }
    }
}
