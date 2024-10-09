package org.example;

import org.example.Exceptions.InvalidTournamentInput;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tournament {
    private List<Player> players;
    private Map<Player, Integer> scores;
    private int noOfRounds;
    private int eliminatedCount;

    public Tournament(List<Player> players, int noOfRounds, int eliminatedCount) {
        if( noOfRounds <=0 || eliminatedCount <=0 || players.isEmpty()){
            throw new InvalidTournamentInput("Round Should be greater Than 0");
        }
        this.players = players;
        this.noOfRounds = noOfRounds;
        this.eliminatedCount = eliminatedCount;
        this.scores = new HashMap<>();
    }

    public void startTournament() {
        for (int i = 0; i < noOfRounds; i++) {
            playRound();
            if(isAlikePopulation()){
                System.out.println("Tournament ended - all players are of same type");
                break;
            }
            evolvePopulation();
            resetScore();
        }
    }

    public void playRound() {
        // Play between every player with everyOther Player
        for (int i = 0; i < players.size(); i++) {
            for (int j = i + 1; j < players.size(); j++) {
                try {
                    Player player1 = players.get(i);
                    Player cloneOfPlayer1 = player1.getClass().getConstructor().newInstance();
                    Player player2 = players.get(j);
                    Player cloneOfPlayer2 = player2.getClass().getConstructor().newInstance();

                    Game game = new Game(cloneOfPlayer1, cloneOfPlayer2, 5);
                    game.playGame();

                    // Merge the clones' scores into the original players' scores
                    scores.merge(player1, cloneOfPlayer1.getScore(), Integer::sum);
                    scores.merge(player2, cloneOfPlayer2.getScore(), Integer::sum);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }


    private void resetScore() {
        scores.clear();
        for (Player player : players) {
            player.resetPoints();
        }
    }

    private void evolvePopulation() {
        List<Map.Entry<Player, Integer>> sortedPlayers = new ArrayList<>(scores.entrySet());
        sortedPlayers.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        List<Player> bestPlayers = new ArrayList<>();
        List<Player> worstPlayers = new ArrayList<>();

        // selecting Top  Players as per Elimination Count
        for(int i=0;i<eliminatedCount;i++){
            bestPlayers.add(sortedPlayers.get(i).getKey());
        }

        // selecting Worst  player
        for (int i = sortedPlayers.size() - 1, count = 0;
             i >= 0 && count < eliminatedCount;
             i--, count++) {
            worstPlayers.add(sortedPlayers.get(i).getKey());
        }
        players.removeAll(worstPlayers);

        for (Player bestPlayer : bestPlayers) {
            try {
                Player clone = bestPlayer.getClass().getDeclaredConstructor().newInstance();
                players.add(clone);
            } catch (Exception e) {
                throw new RuntimeException("Failed to clone player", e);
            }
        }

    }

    private boolean isAlikePopulation() {
        if (players.isEmpty()) return true;
        Class<?> playerType = players.get(0).getClass();
        return players.stream().allMatch(p -> p.getClass().equals(playerType));
    }
}
