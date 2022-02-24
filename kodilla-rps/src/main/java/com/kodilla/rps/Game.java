package com.kodilla.rps;

import java.util.Random;
import java.util.Scanner;

public class Game {

    private final Scanner scanner = new Scanner(System.in);
    private static Game instanceGame = new Game();
    private String playerName;
    private int rounds;
    private char playerNumber;
    private char computerNumber;
    private int playerWin;
    private int computerWin;
    private Figure playerFigure;
    private Figure computerFigure;
    private boolean end = false;

    public static Game getInstanceGame() {
        return instanceGame;
    }

    public String getPlayerName() {
        return playerName;
    }

    public char getPlayerNumber() {
        return playerNumber;
    }

    public char getComputerNumber() {
        return computerNumber;
    }

    public boolean isEnd() {
        return end;
    }

    public void start() {
        playerWin = 0;
        computerWin = 0;
        System.out.println("Welcome to PRS Game!");
        System.out.println("\nRules: " +
                "\n You have to collect more points than your opponent." +
                "\n You can 3 figures to chose:" +
                "\n1. Rock beats Scissors and Lizard" +
                "\n2. Paper beats Rock and Spock" +
                "\n3. Scissors beats Paper and Lizard" +
                "\n4. Spock beats Scissors and Rock" +
                "\n5. Lizard beats Spock and Paper");
        System.out.println("\nPlease, enter your name: ");
        playerName = scanner.next();

        System.out.println("How many rounds would like be won to win?");
        rounds = scanner.nextInt();

        System.out.println("To make your choice press:" +
                "\n1- Rock" +
                "\n2- Paper" +
                "\n3- Scissors" +
                "\n4- Spock" +
                "\n5- Lizard" +
                "\nx- to end game" +
                "\nn- to start new game");
    }

    public void chooseNumber() {
        System.out.println(playerName + ", makes your choice: ");
        playerNumber = scanner.next().charAt(0);

        int random = new Random().nextInt(5) + 1;
        computerNumber = (char) (random + '0');
        if(playerNumber == 'x') {
            endGame();
        }
        else if(playerNumber == 'n') {
            newGame();
        }
    }

    public void getFigures(char playerNumber, char computerNumber) {
        playerFigure = new Figures().figures(playerNumber);
        computerFigure = new Figures().figures(computerNumber);
        System.out.println(playerName + " => " + playerFigure.getFigureName() +
                "\nComputer => " + computerFigure.getFigureName());
    }

    public String getRoundWinner(Figure playerFigure, Figure computerFigure) {
        if(playerFigure.getFigureName().equals(computerFigure.getFigureName())) {
            return "Draw!";
        }
        else if (playerFigure.beats().contains(computerFigure.getFigureName())) {
            playerWin++;
            return "You win!";
        } else {
            computerWin++;
            return "Computer wins!";
        }
    }

    public void play() {
        int roundCounter = 0;
        while(roundCounter < rounds) {
            System.out.println("\nRound #" + (roundCounter + 1));
            roundCounter++;

            chooseNumber();
            getFigures(playerNumber, computerNumber);
            getRoundWinner(playerFigure, computerFigure);

            System.out.println("\nAfter round #" + roundCounter + " " + playerName +
                    " has " + playerWin + " point(s) and Computer has " + computerWin + " point(s)");
        }

        System.out.println("That was a last round.");
        if(playerWin > computerWin) {
            System.out.println("Congratulations!" + "\n Victory is yours!");
        } if (playerWin == computerWin) {
            System.out.println("Draw!" + "\nTry again!");
        } if (playerWin < computerWin) {
            System.out.println("Computer wins!" + "\n Try again!");
        }

        System.out.println("Start again? Press [n] to start a new game or [x] to exit");
        char whatNext = scanner.next().charAt(0);
        switch (whatNext) {
            case 'n': {
                newGame();
                break;
            }
            case 'x': {
                endGame();
                break;
            }
            default:
                break;
        }
    }

    public void newGame() {
        System.out.println("Start a new game? Press [y/n]");
        char newGame = scanner.next().charAt(0);
        switch (newGame) {
            case 'y': {
                start();
                play();
                break;
            }
            case 'n': {
                end = true;
                endGame();
                break;
            }
            default:
                break;
        }
    }

    public void endGame() {
        System.out.println("Are you sure to end? Press [y/n]");
        char endGame = scanner.next().charAt(0);
        switch (endGame) {
            case 'y': {
                end = true;
                System.exit(0);
                break;
            }
            case 'n': {
                newGame();
                break;
            }
            default:
                break;
        }
    }
}
