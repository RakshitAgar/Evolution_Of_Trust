package org.example.Enums;

public enum Points {
    BOTH_COOPERATION(2),
    BOTH_CHEAT(0),
    CHEATER_REWARD(3),
    COOPERATOR_PENALTY(-1);

    private final int value;

    Points(int value) {
        this.value = value;
    }
}