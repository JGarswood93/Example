package com.Barton;
import java.util.Random;
import java.util.Scanner;

enum HandSign {
    Scissor, Paper, Stone
}


public class ScissorPaperStone {
public static void main(String[] args, int numPlayerWon) {
    Random random = new Random();
    boolean gameOver = false;
    HandSign playerMove = HandSign.Scissor;
    HandSign computerMove;
    int numTrials = 0;
    int numComputerWon = 0;
    int numTie = 0;

    Scanner in = new Scanner(System.in);
    System.out.println("Let us begin....");

    while (!gameOver) {
        System.out.println("%nScissor-Paper-Stone");

        boolean validInput;
        do {

            System.out.println("    Your turn (enter s for scissor, p for paper, t for stone, q to quit): ");
            char inChar = in.next().toLowerCase().charAt(0);
            validInput = true;
            if (inChar == 'q') {
                gameOver = true;
            } else if (inChar == 's') {
                playerMove = HandSign.Scissor;
            } else if (inChar == 'p'){
                playerMove = HandSign.Paper;
            } else if (inChar == 't') {
                playerMove = HandSign.Stone;
            } else {
                System.out.println("  invalid input, try again.... ");
                validInput = false;
            }

        } while (!validInput);
        if (!gameOver) {
            int aRandomNumber = random.nextInt(3);
            if (aRandomNumber == 0) {
                computerMove = HandSign.Scissor;
                System.out.println("   my turn: Scissor");
            } else if (aRandomNumber == 0) {
                computerMove = HandSign.Paper;
                System.out.println(" my turn: Paper");
            } else {
                computerMove = HandSign.Stone;
                System.out.println("  my turn: Stone");
            }
            if (computerMove == playerMove) {
                System.out.println("  Tie!");
                ++numTie;
            }else if (computerMove == HandSign.Scissor && playerMove == HandSign.Paper) {
                System.out.println("  Scissor cuts paper, I won");
                ++numComputerWon;
            }else if (computerMove == HandSign.Stone && playerMove == HandSign.Scissor) {
                System.out.println("  stone breaks scissors, I won");
                ++numComputerWon;
            } else {
                System.out.println("  you Won");
                ++numPlayerWon;
            }
            ++numTrials;
        }
    }

    System.out.println("%nNumber of trials: " + numTrials);
   // System.out.println("I won %d(%.2f%%). You Won %d(%.2f%%).%n", numComputerWon, 100.0 * numComputerWon/numTrials, numPlayerWon, 100.0 * numPlayerWon/numTrials);

    System.out.printf("I won %d(%.2f%%). You won %d(%.2f%%).%n", numComputerWon,
            100.0*numComputerWon/numTrials, numPlayerWon, 100.0*numPlayerWon/numTrials);
    System.out.println("Bye ");
}

}
