package org.example;

import org.example.Enums.Move;
import org.example.Players.AlwaysCheatPlayer;
import org.example.Players.AlwaysCooperatePlayer;
import org.example.Players.CopyCatPlayer;
import org.example.Players.DetectivePlayer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    public void testPlayerAlwaysCheatCreation(){
        assertDoesNotThrow(() -> {
            new AlwaysCheatPlayer();
        });
    }

    @Test
    public void testPlayerAlwaysCooperateCreation(){
        assertDoesNotThrow(() -> {
            new AlwaysCooperatePlayer();
        });
    }

    @Test
    public void testCheaterPlayerMove() {
        Player cheater = new AlwaysCheatPlayer();
        Move actualMove = Move.CHEAT;
        assertEquals(cheater.doMove() , actualMove);
    }

    @Test
    public void testCooperatePlayerMove() {
        Player cooperate = new AlwaysCooperatePlayer();
        Move actualMove = Move.COOPERATE;
        assertEquals(cooperate.doMove() , actualMove);
    }

    @Test
    public void testPlayerLooseOnePoints() {
        Player firstPlayer = new AlwaysCheatPlayer();
        firstPlayer.looseOne();

        assertEquals(-1,firstPlayer.getScore());
    }

    @Test
    public void testPlayerLooseOnePointsNegativeCase() {
        Player firstPlayer = new AlwaysCheatPlayer();
        firstPlayer.looseOne();

        assertNotEquals(0,firstPlayer.getScore());
    }

    @Test
    public void testPlayerGainPoints() {
        Player firstPlayer = new AlwaysCheatPlayer();
        firstPlayer.gainThree();

        assertEquals(3,firstPlayer.getScore());
    }

    @Test
    public void testPlayerGainPointsNegativeCase() {
        Player firstPlayer = new AlwaysCheatPlayer();
        firstPlayer.gainThree();

        assertNotEquals(2,firstPlayer.getScore());
    }

    // For Copy Cat Player Previous move
    @Test
    public void testCopyCatPlayerFirstMove() {
        Player firstPlayer = new CopyCatPlayer();
        Move firstMove = firstPlayer.doMove();
        assertEquals(Move.CHEAT,firstMove);
    }

    // detective Player test

    @Test
    public void testDetectivePlayer1Round() {
        Player firstPlayer = new DetectivePlayer();
        Move firstMove = firstPlayer.doMove();
        assertEquals(Move.COOPERATE,firstMove);
    }

    @Test
    public void testDetectivePlayer2Round() {
        Player firstPlayer = new DetectivePlayer();
        Move firstMove = firstPlayer.doMove();
        Move secondMove = firstPlayer.doMove();
        assertEquals(Move.COOPERATE,firstMove);
        assertEquals(Move.CHEAT,secondMove);
    }

    @Test
    public void testResetPoint() {
        Player firstPlayer = new AlwaysCheatPlayer();
        firstPlayer.gainThree();
    }

}