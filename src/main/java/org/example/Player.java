package org.example;

import org.example.Enums.Move;

public abstract class Player {
    protected int score;
    protected Move myLastMove;

    public Player() {
        this.score = 0;
        this.myLastMove = null;
    }

    // Abstract method for making a move
    public abstract Move doMove();

    public void playWith(Player otherPlayer) {
        Move myMove = this.doMove();
        Move opponentMove = otherPlayer.doMove();

        if (myMove == Move.COOPERATE) {
            this.looseOne();
            otherPlayer.gainThree();
        }
        if (opponentMove == Move.COOPERATE) {
            this.gainThree();
            otherPlayer.looseOne();
        }

        this.rememberMove(opponentMove);
        otherPlayer.rememberMove(myMove);
    }

    public abstract void rememberMove(Move opponentMove) ;

    public int getScore() {
        return this.score;
    }

    public void looseOne() {
        this.score -= 1;
    }

    public void gainThree() {
        this.score += 3;
    }

    public void resetPoints() {
        this.score = 0;
    }
}
