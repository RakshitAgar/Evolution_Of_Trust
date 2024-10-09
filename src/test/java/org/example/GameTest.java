package org.example;

import org.example.Exceptions.InvalidRoundException;
import org.example.Players.AlwaysCheatPlayer;
import org.example.Players.AlwaysCooperatePlayer;
import org.example.Players.CopyCatPlayer;


import org.example.Players.DetectivePlayer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    public void testGameWithLessThan0Rounds() {
        Player player1 = new AlwaysCheatPlayer();
        Player player2 = new AlwaysCheatPlayer();

        assertThrows(InvalidRoundException.class, () -> {
            new Game(player1,player2,0);
        });
    }

    @Test
    public void testGameWithLessThan1Rounds() {
        Player player1 = new AlwaysCheatPlayer();
        Player player2 = new AlwaysCheatPlayer();
        assertDoesNotThrow(() -> {
            new Game(player1,player2,1);
        });
    }


    // Test with 5 rounds of game
    @Test
    public void testGameWith5RoundPlayer1CooperateAndPlayer2Cooperate() {
        Player player1 = new AlwaysCooperatePlayer();
        Player player2 = new AlwaysCooperatePlayer();
        Game game = new Game(player1,player2,5);

        game.playGame();
        assertEquals( 10, player1.getScore());
        assertEquals(10 , player2.getScore());
    }

    @Test
    public void testGameWith5RoundPlayer1CheatAndPlayer2Cheat() {
        Player player1 = new AlwaysCheatPlayer();
        Player player2 = new AlwaysCheatPlayer();
        Game game = new Game(player1,player2,5);

        game.playGame();
        assertEquals( 0, player1.getScore());
        assertEquals(0 , player2.getScore());
    }

    @Test
    public void testGameWith5RoundPlayer1CheatAndPlayer2Cooperate() {
        Player player1 = new AlwaysCheatPlayer();
        Player player2 = new AlwaysCooperatePlayer();
        Game game = new Game(player1,player2,5);

        game.playGame();
        assertEquals( 15, player1.getScore());
        assertEquals(-5 , player2.getScore());
    }

    @Test
    public void testGameWith5RoundPlayer1CooperateAndPlayer2Cheat() {
        Player player1 = new AlwaysCooperatePlayer();
        Player player2 = new AlwaysCheatPlayer();
        Game game = new Game(player1,player2,5);

        game.playGame();
        assertEquals( -5, player1.getScore());
        assertEquals(15 , player2.getScore());
    }

    // Test with 3 rounds of game

    @Test
    public void testGameWith3RoundPlayer1CooperateAndPlayer2Cooperate() {
        Player player1 = new AlwaysCooperatePlayer();
        Player player2 = new AlwaysCooperatePlayer();
        Game game = new Game(player1,player2,3);

        game.playGame();
        assertEquals( 6, player1.getScore());
        assertEquals(6 , player2.getScore());
    }


    @Test
    public void testGameWith3RoundPlayer1CheatAndPlayer2Cheat() {
        Player player1 = new AlwaysCheatPlayer();
        Player player2 = new AlwaysCheatPlayer();
        Game game = new Game(player1,player2,3);

        game.playGame();
        assertEquals( 0, player1.getScore());
        assertEquals(0 , player2.getScore());
    }

    //Test for the COPY CAT Player
    @Test
    public void testGameWhenPlayer1IsCopyCatAndPlayer2Cooperate() {
        Player player1 = new CopyCatPlayer();
        Player player2 = new AlwaysCooperatePlayer();

        Game game = new Game(player1,player2,1);
        game.playGame();
        assertEquals( 3, player1.getScore());
        assertEquals(-1 , player2.getScore());
    }

    @Test
    public void testGameWhenPlayer1IsCopyCatAndPlayer2Cheat() {
        Player player1 = new CopyCatPlayer();
        Player player2 = new AlwaysCheatPlayer();

        Game game = new Game(player1,player2,1);
        game.playGame();
        assertEquals( 0, player1.getScore());
        assertEquals(0 , player2.getScore());
    }

    @Test
    public void testGameWhenPlayer1IsCopyCatAndPlayer2CooperateIn2Rounds() {
        Player copyCatPlayer = new CopyCatPlayer();
        Player cooperateplayer = new AlwaysCooperatePlayer();
        Game game = new Game(copyCatPlayer,cooperateplayer,2);
        game.playGame();
        assertEquals( 5, copyCatPlayer.getScore());
        assertEquals( 1 , cooperateplayer.getScore());
    }


    @Test
    public void testGameWhenPlayer1IsCopyCatAndPlayer2CheatIn2Rounds() {
        Player copyCatPlayer = new CopyCatPlayer();
        Player cooperateplayer = new AlwaysCheatPlayer();
        Game game = new Game(copyCatPlayer,cooperateplayer,2);
        game.playGame();
        assertEquals( 0, copyCatPlayer.getScore());
        assertEquals( 0 , cooperateplayer.getScore());
    }

    @Test
    public void testGameWhenBothAreCopyCatPlayer(){
        Player firstPlayer = new CopyCatPlayer();
        Player secondPlayer = new CopyCatPlayer();
        Game game = new Game(firstPlayer,secondPlayer,1);
        game.playGame();
        assertEquals( 0, firstPlayer.getScore());
        assertEquals( 0 , secondPlayer.getScore());
    }

    @Test
    public void testGameWhenBothAreCopyCatPlayerWith2Rounds(){
        Player firstPlayer = new CopyCatPlayer();
        Player secondPlayer = new CopyCatPlayer();
        Game game = new Game(firstPlayer,secondPlayer,2);
        game.playGame();
        assertEquals( 0, firstPlayer.getScore());
        assertEquals( 0 , secondPlayer.getScore());
    }

    @Test
    public void testGameBetweenCheatAndDetectivePlayer(){
        Player firstPlayer = new AlwaysCheatPlayer();
        Player secondPlayer = new DetectivePlayer();
        Game game = new Game(firstPlayer,secondPlayer,5);
        game.playGame();
        assertEquals( 9, firstPlayer.getScore());
        assertEquals( -3 , secondPlayer.getScore());
    }

    @Test
    public void testGameBetweenDetectiveAndCheatPlayer(){
        Player firstPlayer = new DetectivePlayer();
        Player secondPlayer = new AlwaysCheatPlayer();
        Game game = new Game(firstPlayer,secondPlayer,5);
        game.playGame();
        assertEquals( -3, firstPlayer.getScore());
        assertEquals( 9 , secondPlayer.getScore());
    }

    @Test
    public void testGameBetweenDetectiveAndAlwaysCooperatePlayer(){
        Player firstPlayer = new DetectivePlayer();
        Player secondPlayer = new AlwaysCooperatePlayer();
        Game game = new Game(firstPlayer,secondPlayer,5);
        game.playGame();
        assertEquals( 12, firstPlayer.getScore());
        assertEquals( 4 , secondPlayer.getScore());
    }

    @Test
    public void testGameBetweenAlwaysCooperateAndDetectivePlayer(){
        Player firstPlayer = new AlwaysCooperatePlayer();
        Player secondPlayer = new DetectivePlayer();
        Game game = new Game(firstPlayer,secondPlayer,5);
        game.playGame();
        assertEquals( 4, firstPlayer.getScore());
        assertEquals( 12 , secondPlayer.getScore());
    }

    @Test
    public void testGameBetweenDetectiveAndCopyCatPlayer(){
        Player firstPlayer = new CopyCatPlayer();
        Player secondPlayer = new DetectivePlayer();
        Game game = new Game(firstPlayer,secondPlayer,5);
        game.playGame();
        assertEquals( 9, firstPlayer.getScore());
        assertEquals( 5 , secondPlayer.getScore());
    }

    @Test
    public void testGameBetweenCopyCatAndDetectivePlayer(){
        Player firstPlayer = new CopyCatPlayer();
        Player secondPlayer = new DetectivePlayer();
        Game game = new Game(firstPlayer,secondPlayer,5);
        game.playGame();
        assertEquals( 9, firstPlayer.getScore());
        assertEquals( 5 , secondPlayer.getScore());
    }

    @Test
    public void testGameBetweenDetectiveAndDetectivePlayer(){
        Player firstPlayer = new DetectivePlayer();
        Player secondPlayer = new DetectivePlayer();
        Game game = new Game(firstPlayer,secondPlayer,5);
        game.playGame();
        assertEquals( 8, firstPlayer.getScore());
        assertEquals( 8 , secondPlayer.getScore());
    }

}