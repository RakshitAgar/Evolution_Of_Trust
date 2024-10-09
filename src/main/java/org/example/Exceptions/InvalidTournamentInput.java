package org.example.Exceptions;

public class InvalidTournamentInput extends RuntimeException {
    public InvalidTournamentInput(String message) {
        super(message);
    }
}
