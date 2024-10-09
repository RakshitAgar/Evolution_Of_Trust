package org.example;

import org.example.Exceptions.InvalidTournamentInput;
import org.example.Players.AlwaysCheatPlayer;
import org.example.Players.AlwaysCooperatePlayer;
import org.example.Players.CopyCatPlayer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TournamentTest {
    private List<Player> players;

    @BeforeEach
    public void setUp() {
        players = new ArrayList<>();
        for(int i=0;i<5;i++){
            players.add(new AlwaysCooperatePlayer());
            players.add(new AlwaysCheatPlayer());
            players.add(new CopyCatPlayer());
        }
    }


    @Test
    public void testTournamentWithInvalidRounds() {
        List<Player> players = new ArrayList<>();
        players.add(new AlwaysCheatPlayer());
        assertThrows(InvalidTournamentInput.class , () -> {
            new Tournament(players,0,3);
        });
    }

    @Test
    public void testTournamentWithValidRoundsAndProperPlayerCount() {
        List<Player> players = new ArrayList<>();
        players.add(new AlwaysCheatPlayer());
        assertDoesNotThrow(() -> {
            new Tournament(players,2,3);
        });
    }

    @Test
    public void testTournamentWithZeroPlayerRounds() {
        List<Player> players = new ArrayList<>();
        assertThrows(InvalidTournamentInput.class , () -> {
            new Tournament(players,1,3);
        });
    }

    @Test
    public void testTournamentWith1Round15player() {
        Tournament tournament = new Tournament(players,10,3);
        tournament.startTournament();
    }

    @Test
    public void testTournamentForCopyCatPlayerInOneRoundCompetingTwoPlayers() {
        List<Player> playersList = new ArrayList<>();
        Player player1 = new CopyCatPlayer();
        Player player2 = new AlwaysCheatPlayer();
        Player player3 = new AlwaysCooperatePlayer();
        playersList.add(player1);
        playersList.add(player2);
        playersList.add(player3);

        Tournament tournament = new Tournament(playersList,10,3);
        tournament.startTournament();
    }

}