package org.example.Players;

import org.example.Enums.Move;
import org.example.Player;

public class AlwaysCooperatePlayer extends Player {

    @Override
    public Move doMove() {
        return Move.COOPERATE;
    }

    @Override
    public void rememberMove(Move opponentMove) {

    }
}
