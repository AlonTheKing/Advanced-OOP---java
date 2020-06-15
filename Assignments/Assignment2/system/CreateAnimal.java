package system;

import Animals.Gender;
import Mobility.Point;
import Olympics.Medal;
import graphics.CompetitionFrame;

import java.awt.*;
import java.util.Arrays;
import java.util.Scanner;

public class CreateAnimal {
    protected Gender myGender;
    protected String name;
    protected Double weight;
    protected Double speed;
    protected Medal[] medal;
    protected Point position;


    public CreateAnimal(String animal, CompetitionFrame other) {
        Scanner userInput = new Scanner(java.lang.System.in);


        java.lang.System.out.println("Please enter a name for the " + animal + ": ");
        name = userInput.next();


        java.lang.System.out.println("Please choose the Gender of the " + animal + ":\n(*) for Male press - 1.\n(*) for Female press - 2.\n(*) for Hermaphrodite press - 3. ");
        int animalGender_key = userInput.nextInt();
        String animalGender = null;
        switch (animalGender_key) {
            case 1 -> animalGender = "Male";
            case 2 -> animalGender = "Female";
            case 3 -> animalGender = "Hermaphrodite";
            default -> java.lang.System.out.println("bad pick! try again.");
        }

        boolean flag = false;
        Gender gender;

        //let's check if the string is included in the enum set.
        for (Gender x : Gender.values()) {
            if (x.name().equals(animalGender)) {
                flag = true;
                break;
            }
        }

        if (!flag) {
            java.lang.System.out.println("wrong input! atone!");
            java.lang.System.exit(0);
        }

        myGender = Gender.valueOf(animalGender);


        java.lang.System.out.println("Please enter the weight of the " + animal + ": ");
        weight = userInput.nextDouble();

        java.lang.System.out.println("Please enter the speed of the " + animal + ": ");
        speed = userInput.nextDouble();

        java.lang.System.out.println("How many medals the " + animal + " has: ");
        int amountOfMedals = userInput.nextInt();

        //creating an array of pointers to Medal.
        medal = new Medal[amountOfMedals];

        for (int j = 0; j < amountOfMedals; ++j) {
            java.lang.System.out.println("Which medal " + animal + " have:\n(*) Gold - press 1.\n(*) Silver - press 2.\n(*) Bronze - press 3. ");
            int animalMedal_key = userInput.nextInt();
            String val = null;
            switch (animalMedal_key) {
                case 1 -> val = "gold";
                case 2 -> val = "silver";
                case 3 -> val = "bronze";
                default -> java.lang.System.out.println("bad pick! try again.");
            }


            flag = false;
            Medal.myMedal z;

            //let's check if the string is included in the enum set.
            for (Medal.myMedal x : Medal.myMedal.values()) {
                if (x.name().equals(val)) {
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                java.lang.System.out.println("wrong input! atone!");
                java.lang.System.exit(0);
            }

            z = Medal.myMedal.valueOf(val);

            java.lang.System.out.println("On which tournament he won?: ");
            String tournament = userInput.next();

            java.lang.System.out.println("On which year it was?: ");
            int year = userInput.nextInt();

            medal[j] = new Medal(z, tournament, year);

        }
       if (animal.equals("Dog")||animal.equals("Cat")||animal.equals("Snake")||animal.equals("Alligator")) {
           position = new Point(0, 20);
       }
       else if(animal.equals("Whale")||animal.equals("Dolphin")) {
           position = new Point(50, 0);
       }
       else {
           position = new Point(0, 100);
       }
    }

    public Gender getMyGender() {
        return myGender;
    }

    public String getName() {
        return name;
    }

    public Double getWeight() {
        return weight;
    }

    public Double getSpeed() {
        return speed;
    }

    public Medal[] getMedal() {
        return medal;
    }

    public Point getPosition() {
        return position;
    }
}
