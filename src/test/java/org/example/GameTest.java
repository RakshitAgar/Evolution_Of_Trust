package org.example;

import org.example.Enums.PlayerType;
import org.example.Exceptions.InvalidRoundException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    public void testGameWithLessThan0Rounds() {
        Player player1 = new Player(PlayerType.ALWAYS_CHEAT);
        Player player2 = new Player(PlayerType.ALWAYS_CHEAT);

        assertThrows(InvalidRoundException.class, () -> {
            new Game(player1,player2,0);
        });
    }

    @Test
    public void testGameWithLessThan1Rounds() {
        Player player1 = new Player(PlayerType.ALWAYS_CHEAT);
        Player player2 = new Player(PlayerType.ALWAYS_CHEAT);
        assertDoesNotThrow(() -> {
            new Game(player1,player2,1);
        });
    }


    // Test with 5 rounds of game
    @Test
    public void testGameWith5RoundPlayer1CooperateAndPlayer2Cooperate() {
        Player player1 = new Player(PlayerType.ALWAYS_COOPERATE);
        Player player2 = new Player(PlayerType.ALWAYS_COOPERATE);
        Game game = new Game(player1,player2,5);

        game.playGame();
        assertEquals( 10, player1.getScore());
        assertEquals(10 , player2.getScore());
    }

    @Test
    public void testGameWith5RoundPlayer1CheatAndPlayer2Cheat() {
        Player player1 = new Player(PlayerType.ALWAYS_CHEAT);
        Player player2 = new Player(PlayerType.ALWAYS_CHEAT);
        Game game = new Game(player1,player2,5);

        game.playGame();
        assertEquals( 0, player1.getScore());
        assertEquals(0 , player2.getScore());
    }

    @Test
    public void testGameWith5RoundPlayer1CheatAndPlayer2Cooperate() {
        Player player1 = new Player(PlayerType.ALWAYS_CHEAT);
        Player player2 = new Player(PlayerType.ALWAYS_COOPERATE);
        Game game = new Game(player1,player2,5);

        game.playGame();
        assertEquals( 15, player1.getScore());
        assertEquals(-5 , player2.getScore());
    }

    @Test
    public void testGameWith5RoundPlayer1CooperateAndPlayer2Cheat() {
        Player player1 = new Player(PlayerType.ALWAYS_COOPERATE);
        Player player2 = new Player(PlayerType.ALWAYS_CHEAT);
        Game game = new Game(player1,player2,5);

        game.playGame();
        assertEquals( -5, player1.getScore());
        assertEquals(15 , player2.getScore());
    }

    // Test with 3 rounds of game

    @Test
    public void testGameWith3RoundPlayer1CooperateAndPlayer2Cooperate() {
        Player player1 = new Player(PlayerType.ALWAYS_COOPERATE);
        Player player2 = new Player(PlayerType.ALWAYS_COOPERATE);
        Game game = new Game(player1,player2,3);

        game.playGame();
        assertEquals( 6, player1.getScore());
        assertEquals(6 , player2.getScore());
    }


    @Test
    public void testGameWith3RoundPlayer1CheatAndPlayer2Cheat() {
        Player player1 = new Player(PlayerType.ALWAYS_CHEAT);
        Player player2 = new Player(PlayerType.ALWAYS_CHEAT);
        Game game = new Game(player1,player2,3);

        game.playGame();
        assertEquals( 0, player1.getScore());
        assertEquals(0 , player2.getScore());
    }

}