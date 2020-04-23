/*
name: david charon zade
id: 312797426
 */

import java.util.Scanner;


public class GameDriver {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        int key;
        System.out.println("choose which game would you like:\n(*) Prisoner's dilemma? - Press 1.\n(*) Rock Paper Scissors - Press 2 ");

        key = userInput.nextInt();

        switch (key) {
            case 1: {
                System.out.println("choose against which player would you like to play?:\n(*) Consecutive Player  - Press 1.\n(*) Random Player - Press 2 ");
                key = userInput.nextInt();
                switch (key) {
                    case 1: {
                        // consecutive player

                        String name;
                        System.out.println("what's your name?");
                        name = userInput.next();
                        System.out.println("what's the other player name?:");
                        ConsecutivePlayer myPlayer = new ConsecutivePlayer(name);
                        name = userInput.next();
                        ConsecutivePlayer otherPlayer = new ConsecutivePlayer(name);

                        PrisonerDilemmas myGame = new PrisonerDilemmas(myPlayer, otherPlayer);
                        myGame.play(2);
                        System.out.println("***The winner is:***\n");
                        if (myPlayer.isWinner(otherPlayer)) {
                            System.out.println("***********");
                            System.out.println("   " + myPlayer.getName());
                            System.out.println("***********");
                        } else {
                            System.out.println("***********");
                            System.out.println("   " + otherPlayer.getName());
                            System.out.println("***********");
                        }
                        break;

                    }
                    case 2: {
                        // random player

                        String name;
                        System.out.println("what's your name?");
                        name = userInput.next();
                        ConsecutivePlayer myPlayer = new ConsecutivePlayer(name);
                        RandomPlayer otherPlayer = new RandomPlayer("Random player");

                        PrisonerDilemmas myGame = new PrisonerDilemmas(myPlayer, otherPlayer);
                        myGame.play(2);
                        System.out.println("***The winner is:***\n");
                        if (myPlayer.isWinner(otherPlayer)) {
                            System.out.println("***********");
                            System.out.println(" " + myPlayer.getName());
                            System.out.println("***********");
                        } else {
                            System.out.println("***********");
                            System.out.println(" " + otherPlayer.getName());
                            System.out.println("***********");
                        }
                        break;
                    }
                }
            }
            case 2: {

                System.out.println("choose against which player would you like to play?:\n(*) Consecutive Player  - Press 1.\n(*) Random Player - Press 2 ");
                key = userInput.nextInt();
                switch (key) {
                    case 1: {
                        // consecutive player

                        String name;
                        System.out.println("what's your name?");
                        name = userInput.next();
                        System.out.println("what's the other player name?:");
                        ConsecutivePlayer myPlayer = new ConsecutivePlayer(name);
                        name = userInput.next();
                        ConsecutivePlayer otherPlayer = new ConsecutivePlayer(name);

                        RockPaperScissors myGame = new RockPaperScissors(myPlayer, otherPlayer);
                        myGame.play(2);
                        System.out.println("***The winner is:***\n");
                        if (myPlayer.isWinner(otherPlayer)) {
                            System.out.println("***********");
                            System.out.println("   " + myPlayer.getName());
                            System.out.println("***********");
                        } else {
                            System.out.println("***********");
                            System.out.println("   " + otherPlayer.getName());
                            System.out.println("***********");
                        }
                        break;

                    }
                    case 2: {
                        {
                            // random player

                            String name;

                            System.out.println("what's your name?");
                            name = userInput.next();
                            ConsecutivePlayer myPlayer = new ConsecutivePlayer(name);
                            RandomPlayer otherPlayer = new RandomPlayer("Random player");

                            RockPaperScissors myGame = new RockPaperScissors(myPlayer, otherPlayer);
                            myGame.play(2);
                            System.out.println("***The winner is:***\n");
                            if (myPlayer.isWinner(otherPlayer)) {
                                System.out.println("***********");
                                System.out.println(" " + myPlayer.getName());
                                System.out.println("***********");
                            } else {
                                System.out.println("***********");
                                System.out.println(" " + otherPlayer.getName());
                                System.out.println("***********");
                            }
                            break;
                        }
                    }
                }
            }
        }

    }

}

