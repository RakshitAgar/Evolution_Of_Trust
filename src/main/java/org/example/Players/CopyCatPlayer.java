package org.example.Players;

import org.example.Enums.Move;
import org.example.Player;

public class CopyCatPlayer extends Player {

    private Move lastOpponentMove;

    public CopyCatPlayer() {
        super();
        this.lastOpponentMove = null;
    }

    @Override
    public Move doMove() {
        if (this.lastOpponentMove == null) {
            return Move.CHEAT;
        }
        return lastOpponentMove;
    }

    @Override
    public void rememberMove(Move opponentMove) {
        this.lastOpponentMove = opponentMove;
    }
}
