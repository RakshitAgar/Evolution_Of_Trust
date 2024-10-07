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
    public void testPlayerLoosePoints() {
        Player firstPlayer = new Player(PlayerType.ALWAYS_CHEAT);
        firstPlayer.loose();

        assertEquals(-1,firstPlayer.getScore());
    }

    @Test
    public void testPlayerLoosePointsNegativeCase() {
        Player firstPlayer = new Player(PlayerType.ALWAYS_CHEAT);
        firstPlayer.loose();

        assertNotEquals(0,firstPlayer.getScore());
    }

    @Test
    public void testPlayerGainPoints() {
        Player firstPlayer = new Player(PlayerType.ALWAYS_CHEAT);
        firstPlayer.gainThree();

        assertEquals(3,firstPlayer.getScore());
    }

    @Test
    public void testPlayerGainPointsNegativeCase() {
        Player firstPlayer = new Player(PlayerType.ALWAYS_CHEAT);
        firstPlayer.gainThree();

        assertNotEquals(2,firstPlayer.getScore());
    }
}