package com.kodilla.rps;

public final class Figures {

    private static final String rock = "Rock!";
    private static final String paper = "Paper!";
    private static final String scissors = "Scissors!";
    private static final String spock = "Spock!";
    private static final String lizard = "Lizard!";

    public static String getRock() {
        return rock;
    }

    public static String getPaper() {
        return paper;
    }

    public static String getScissors() {
        return scissors;
    }

    public static String getSpock() {
        return spock;
    }

    public static String getLizard() {
        return lizard;
    }

    public final Figure figures (char figureNumber) {
        switch (figureNumber) {
            case '1':
                return new Rock(rock);
            case '2':
                return new Paper(paper);
            case '3':
                return new Scissors(scissors);
            case '4':
                return new Spock(spock);
            case '5':
                return new Lizard(lizard);
            default:
                return null;
        }
    }
}
