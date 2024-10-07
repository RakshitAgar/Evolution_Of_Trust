package org.example;

import org.example.Enums.Move;
import org.example.Enums.PlayerType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    public void testPlayerAlwaysCheatCreation(){
        assertDoesNotThrow(() -> {
            new Player(PlayerType.ALWAYS_CHEAT);
        });
    }

    @Test
    public void testPlayerAlwaysCooperateCreation(){
        assertDoesNotThrow(() -> {
            new Player(PlayerType.ALWAYS_COOPERATE);
        });
    }

    @Test
    public void testCheaterPlayerMove() {
        Player cheater = new Player(PlayerType.ALWAYS_CHEAT);
        Move actualMove = Move.CHEAT;
        assertEquals(cheater.doMove() , actualMove);
    }

    @Test
    public void testCooperatePlayerMove() {
        Player cooperate = new Player(PlayerType.ALWAYS_COOPERATE);
        Move actualMove = Move.COOPERATE;
        assertEquals(cooperate.doMove() , actualMove);
    }

    @Test
    public void testPlayerAddPointWhenWeHaveBothCooperates() {
        Player firstPlayer = new Player(PlayerType.ALWAYS_COOPERATE);
        firstPlayer.addPoints(Move.COOPERATE);
        assertEquals(firstPlayer.getScore(),2);
    }

    @Test
    public void testPlayerAddPointWhenWeHaveBothCheat() {
        Player firstPlayer = new Player(PlayerType.ALWAYS_CHEAT);
        firstPlayer.addPoints(Move.CHEAT);
        assertEquals(firstPlayer.getScore(),0);
    }


    @Test
    public void testPlayerAddPointWhenWeHaveBothDifferent() {
        Player firstPlayer = new Player(PlayerType.ALWAYS_CHEAT);
        firstPlayer.addPoints(Move.COOPERATE);
        assertEquals(firstPlayer.getScore(),3);
    }

    @Test
    public void testPlayerAddPointWhenWeHaveBothDifferentFirstPlayerCooperate() {
        Player firstPlayer = new Player(PlayerType.ALWAYS_COOPERATE);
        firstPlayer.addPoints(Move.CHEAT);
        assertEquals(firstPlayer.getScore(),-1);
    }

}