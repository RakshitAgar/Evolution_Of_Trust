package org.example;

import org.example.Enums.Move;
import org.example.Players.AlwaysCheatPlayer;
import org.example.Players.AlwaysCooperatePlayer;
import org.example.Players.CopyCatPlayer;
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
    public void testPlayerLoosePoints() {
        Player firstPlayer = new AlwaysCheatPlayer();
        firstPlayer.loose();

        assertEquals(-1,firstPlayer.getScore());
    }

    @Test
    public void testPlayerLoosePointsNegativeCase() {
        Player firstPlayer = new AlwaysCheatPlayer();
        firstPlayer.loose();

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



}