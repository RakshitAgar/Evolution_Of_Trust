package org.example.Players;

import org.example.Enums.Move;
import org.example.Player;

public class AlwaysCheatPlayer extends Player {

    @Override
    public Move doMove() {
        return Move.CHEAT;
    }

    @Override
    public void rememberMove(Move opponentMove) {

    }
}
