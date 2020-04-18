/*

 *****************************
 *****************************
 ** NAME: David charon-zade **
 ** ID: 312797426           **
 *****************************
 *****************************
 */

/*
package - system
 */
package system;

/*
imports:java.util.*, Animals.*, Mobility.Point, Olympics.Medal
 */

import java.util.*;

import Animals.*;
import Mobility.Point;
import Olympics.Medal;

/*
this class represents the System.
 */
public class system {
    /*
    this static point is our's system starting point
     */
    public static void main(String[] args) {
        int i = 0;
        // creating a reference to a scanner for user input.
        Scanner userInput = new Scanner(System.in);

        System.out.println("Enter how many Animals would you like to create?");

        //getting a size of the user (int).
        int numOfAnimals = userInput.nextInt();

        // array of Animals pointers.
        Animal[] myAnimal = new Animal[numOfAnimals];

        while (i < numOfAnimals) {
            System.out.println("Please choose, which of the following Animal types you'd like to create:\n(*) Terrestrial Animal - Press 1.\n(*) Air Animal - Press 2.\n(*) Water Animal - Press 3.");

            //getting a user input.
            int animalTypeSelection = userInput.nextInt();

            //switch case to test the validation of the input.
            switch (animalTypeSelection) {

                //Terrestrial animal.
                case 1:

                    System.out.println("Please choose which of the following Terrestrial Animals would you like to have:\n(*) Dog - Press 1.\n(*) Cat- Press 2.\n(*) Snake - Press 3.\n");

                    //getting input from the user. (int)
                    int terrestrialSelection = userInput.nextInt();

                    switch (terrestrialSelection) {
                        case 1:
                            //getting the dog's information.
                            myAnimal[i] = createDog();
                            i += 1;
                            // create another switch for -> toString (all the info regard the animal), makeSound, exit the System
                            break;

                        case 2:
                            //getting the cat's information.
                            myAnimal[i] = createCat();
                            i += 1;
                            // create another switch for -> toString (all the info regard the animal), makeSound, exit the System
                            break;

                        case 3:
                            myAnimal[i] = createSnake();
                            i += 1;
                            // create another switch for -> toString (all the info regard the animal), makeSound, exit the System
                            break;

                        default:
                            System.out.println("you have chosen poorly, atone! ");
                            break;
                    }
                    break;

                //Air animal.
                case 2:

                    System.out.println("Please choose which of the following Air Animals would you like to have:\n(*) Eagle - Press 1.\n(*) Pigeon - Press 2.");
                    int airSelection = userInput.nextInt();

                    switch (airSelection) {
                        case 1:

                            myAnimal[i] = createEagle();
                            i += 1;
                            // create another switch for -> toString (all the info regard the animal), makeSound, exit the System
                            break;

                        case 2:
                            myAnimal[i] = createPigeon();
                            i += 1;
                            // create another switch for -> toString (all the info regard the animal), makeSound, exit the System
                            break;

                        default:
                            System.out.println("you have chosen poorly, atone! ");
                            break;
                    }

                    break;

                //Water animal.
                case 3:

                    System.out.println("Please choose which of the following Water Animals would you like to have:\n(*) Alligator - Press 1.\n(*) Whale  - Press 2.\n(*) Dolphin - press 3.");
                    int waterSelection = userInput.nextInt();

                    switch (waterSelection) {
                        case 1:
                            myAnimal[i] = createAlligator();
                            i += 1;
                            break;

                        case 2:
                            myAnimal[i] = createWhale();
                            i += 1;
                            break;

                        case 3:
                            myAnimal[i] = createDolphin();
                            i += 1;
                            break;

                        default:
                            System.out.println("you have chosen poorly, atone! ");
                            break;
                    }
                    break;
                default:
                    System.out.println("you have chosen poorly, atone! ");
                    break;
            }
        }

        userMenu(myAnimal);
    }

    /*
    this function gives the user the menu about the operations he can do with the zoo he created.
    @param: myZoo is the array of animals that the user created
     */
    public static Boolean userMenu(Animal[] myZoo) {

        System.out.println("*** Please choose of on the following options: ***\n(*) Information about the animals that you created - press 1.\n(*) Sound of each animal you created - press 2.\n(*) To exit - press 3.\n");
        Scanner userInput = new Scanner(System.in);
        int key = userInput.nextInt();

        switch (key) {
            case 1:
                for (Animal animal : myZoo) {
                    System.out.println(animal.toString());
                }
                break;
            case 2:
                for (Animal animal : myZoo) {
                    animal.makeSound();
                }
                break;
            case 3:
                System.out.println("Thank you.");
                System.exit(1);
                break;

            default:
                System.out.println("Invalid choice! atone!\n");
                break;
        }
        return true;
    }


    /*
    this function creates an instance of a Dolphin with the required Dolphin's information
    @return Dolphin's instance.
     */
    private static Dolphin createDolphin() {
        String animal = "Dolphin";

        //scanner object.
        Scanner userInput = new Scanner(System.in);


        System.out.println("Please enter a name for the " + animal + ": ");
        String animalName = userInput.next();
        System.out.println("Please choose the Gender of the " + animal + ":\n (*) for Male press - 1.\n(*) for Female press - 2.\n(*) for Hermaphrodite press - 3. ");
        int animalGender_key = userInput.nextInt();
        String animalGender = null;
        switch (animalGender_key) {
            case 1:
                animalGender = "Male";
                break;
            case 2:
                animalGender = "Female";
                break;
            case 3:
                animalGender = "Hermaphrodite";
                break;
            default:
                System.out.println("bad pick! try again.");
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
            System.out.println("wrong input! atone!");
            System.exit(0);
        }

        gender = Gender.valueOf(animalGender);

        System.out.println("Please enter the weight of the " + animal + ": ");
        double animalWeight = userInput.nextDouble();

        System.out.println("Please enter the speed of the " + animal + ": ");
        double animalSpeed = userInput.nextDouble();

        System.out.println("How many medals the " + animal + " has: ");
        int amountOfMedals = userInput.nextInt();

        //creating an array of pointers to Medal.
        Medal[] animalMedals = new Medal[amountOfMedals];

        for (int j = 0; j < amountOfMedals; ++j) {
            System.out.println("Which medal " + animal + " have:\n(*) Gold - press 1.\n(*) Silver - press 2.\n(*) Bronze - press 3. ");
            int animalMedal_key = userInput.nextInt();
            String val = null;
            switch (animalMedal_key) {
                case 1:
                    val = "gold";
                    break;
                case 2:
                    val = "silver";
                    break;
                case 3:
                    val = "bronze";
                    break;
                default:
                    System.out.println("bad pick! try again.");
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
                System.out.println("wrong input! atone!");
                System.exit(0);
            }

            z = Medal.myMedal.valueOf(val);

            System.out.println("On which tournament he won?: ");
            String tournament = userInput.next();

            System.out.println("On which year it was?: ");
            int year = userInput.nextInt();

            animalMedals[j] = new Medal(z, tournament, year);

        }

        Point myPoint = new Point(50, 0);

        System.out.println("Please enter " + animal + "'s dive depth:");
        double diveDepth = userInput.nextDouble();

        System.out.println("In which water the " + animal + " lives?: ");
        String dolType = userInput.next();
        flag = false;
        Dolphin.WaterType z;

        //let's check if the string is included in the enum set.
        for (Dolphin.WaterType x : Dolphin.WaterType.values()) {
            if (x.name().equals(dolType)) {
                flag = true;
                break;
            }
        }

        if (!flag) {
            System.out.println("wrong input! atone!");
            System.exit(0);
        }

        z = Dolphin.WaterType.valueOf(dolType);


        return new Dolphin(z, diveDepth, animalName, gender, animalWeight, animalSpeed, animalMedals, myPoint);
    }

    /*
    this function creates an instance of a Whale with the required Whale's information
    @return Whale's instance.
     */
    private static Whale createWhale() {
        String animal = "Whale";

        //scanner object.
        Scanner userInput = new Scanner(System.in);


        System.out.println("Please enter a name for the " + animal + ": ");
        String animalName = userInput.next();

        System.out.println("Please choose the Gender of the " + animal + ":\n(*) for Male - press 1.\n(*) for Female - press 2.\n(*) for Hermaphrodite press - 3. ");
        int animalGender_key = userInput.nextInt();
        String animalGender = null;
        switch (animalGender_key) {
            case 1:
                animalGender = "Male";
                break;
            case 2:
                animalGender = "Female";
                break;
            case 3:
                animalGender = "Hermaphrodite";
                break;
            default:
                System.out.println("bad pick! try again.");
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
            System.out.println("wrong input! atone!");
            System.exit(0);
        }

        gender = Gender.valueOf(animalGender);

        System.out.println("Please enter the weight of the " + animal + ": ");
        double animalWeight = userInput.nextDouble();

        System.out.println("Please enter the speed of the " + animal + ": ");
        double animalSpeed = userInput.nextDouble();

        System.out.println("How many medals the " + animal + " has: ");
        int amountOfMedals = userInput.nextInt();

        //creating an array of pointers to Medal.
        Medal[] animalMedals = new Medal[amountOfMedals];

        for (int j = 0; j < amountOfMedals; ++j) {
            System.out.println("Which medal " + animal + " have:\n(*) Gold - press 1.\n(*) Silver - press 2.\n(*) Bronze - press 3. ");
            int animalMedal_key = userInput.nextInt();
            String val = null;
            switch (animalMedal_key) {
                case 1:
                    val = "gold";
                    break;
                case 2:
                    val = "silver";
                    break;
                case 3:
                    val = "bronze";
                    break;
                default:
                    System.out.println("bad pick! try again.");
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
                System.out.println("wrong input! atone!");
                System.exit(0);
            }

            z = Medal.myMedal.valueOf(val);

            System.out.println("On which tournament he won?: ");
            String tournament = userInput.next();

            System.out.println("On which year it was?: ");
            int year = userInput.nextInt();

            animalMedals[j] = new Medal(z, tournament, year);

        }

        Point myPoint = new Point(50, 0);

        System.out.println("Please enter " + animal + "'s dive depth:");
        double diveDepth = userInput.nextDouble();

        System.out.println("Please enter " + animal + "'s food type: ");
        String foodType = userInput.next();

        return new Whale(foodType, diveDepth, animalName, gender, animalWeight, animalSpeed, animalMedals, myPoint);

    }

    /*
    this function creates an instance of a Alligator with the required Alligator's information
    @return Alligator's instance.
     */
    private static Alligator createAlligator() {
        String animal = "Alligator";

        //scanner object.
        Scanner userInput = new Scanner(System.in);


        System.out.println("Please enter a name for the " + animal + ": ");
        String animalName = userInput.next();

        System.out.println("Please choose the Gender of the " + animal + ":\n(*) for Male press - 1.\n(*) for Female press - 2.\n(*) for Hermaphrodite - press 3. ");
        int animalGender_key = userInput.nextInt();
        String animalGender = null;
        switch (animalGender_key) {
            case 1:
                animalGender = "Male";
                break;
            case 2:
                animalGender = "Female";
                break;
            case 3:
                animalGender = "Hermaphrodite";
                break;
            default:
                System.out.println("bad pick! try again.");
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
            System.out.println("wrong input! atone!");
            System.exit(0);
        }

        gender = Gender.valueOf(animalGender);

        System.out.println("Please enter the weight of the " + animal + ": ");
        double animalWeight = userInput.nextDouble();

        System.out.println("Please enter the speed of the " + animal + ": ");
        double animalSpeed = userInput.nextDouble();
        while ((int) animalSpeed > 5) {
            System.out.println(animal + "'s speed cannot be more than 5 km/h, please change the input:");
            animalSpeed = userInput.nextDouble();
        }

        System.out.println("How many medals the " + animal + " has: ");
        int amountOfMedals = userInput.nextInt();

        //creating an array of pointers to Medal.
        Medal[] animalMedals = new Medal[amountOfMedals];

        for (int j = 0; j < amountOfMedals; ++j) {
            System.out.println("Which medal " + animal + " have:\n(*) Gold - press 1.\n(*) Silver - press 2.\n(*) Bronze - press 3. ");
            int animalMedal_key = userInput.nextInt();
            String val = null;
            switch (animalMedal_key) {
                case 1:
                    val = "gold";
                    break;
                case 2:
                    val = "silver";
                    break;
                case 3:
                    val = "bronze";
                    break;
                default:
                    System.out.println("bad pick! try again.");
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
                System.out.println("wrong input! atone!");
                System.exit(0);
            }

            z = Medal.myMedal.valueOf(val);

            System.out.println("On which tournament he won?: ");
            String tournament = userInput.next();

            System.out.println("On which year it was?: ");
            int year = userInput.nextInt();

            animalMedals[j] = new Medal(z, tournament, year);

        }


        Point myPoint = new Point(50, 0);

        System.out.println("Please enter " + animal + "'s dive depth:");
        double diveDepth = userInput.nextDouble();

        System.out.println("Please enter " + animal + "'s area of living: ");
        String areaOfLiving = userInput.next();

        return new Alligator(areaOfLiving, diveDepth, animalName, gender, animalWeight, animalSpeed, animalMedals, myPoint);
    }

    /*
    this function creates an instance of a Pigeon with the required Pigeon's information
    @return Pigeon's instance.
     */
    private static Pigeon createPigeon() {
        String animal = "Pigeon";

        //scanner object.
        Scanner userInput = new Scanner(System.in);


        System.out.println("Please enter a name for the " + animal + ": ");
        String animalName = userInput.next();

        System.out.println("Please choose the Gender of the " + animal + ":\n(*) for Male - press 1.\n(*) for Female - press 2.\n(*) for Hermaphrodite - press 3. ");
        int animalGender_key = userInput.nextInt();
        String animalGender = null;

        switch (animalGender_key) {
            case 1:
                animalGender = "Male";
                break;
            case 2:
                animalGender = "Female";
                break;
            case 3:
                animalGender = "Hermaphrodite";
                break;
            default:
                System.out.println("bad pick! try again.");
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
            System.out.println("wrong input! atone!");
            System.exit(0);
        }

        gender = Gender.valueOf(animalGender);

        System.out.println("Please enter the weight of the " + animal + ": ");
        double animalWeight = userInput.nextDouble();

        System.out.println("Please enter the speed of the " + animal + ": ");
        double animalSpeed = userInput.nextDouble();

        System.out.println("How many medals the " + animal + " has: ");
        int amountOfMedals = userInput.nextInt();

        //creating an array of pointers to Medal.
        Medal[] animalMedals = new Medal[amountOfMedals];

        for (int j = 0; j < amountOfMedals; ++j) {
            System.out.println("Which medal " + animal + " have:\n(*) Gold - press 1.\n(*) Silver - press 2.\n(*) Bronze - press 3. ");
            int animalMedal_key = userInput.nextInt();
            String val = null;
            switch (animalMedal_key) {
                case 1:
                    val = "gold";
                    break;
                case 2:
                    val = "silver";
                    break;
                case 3:
                    val = "bronze";
                    break;
                default:
                    System.out.println("bad pick! try again.");
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
                System.out.println("wrong input! atone!");
                System.exit(0);
            }

            z = Medal.myMedal.valueOf(val);

            System.out.println("On which tournament he won?: ");
            String tournament = userInput.next();

            System.out.println("On which year it was?: ");
            int year = userInput.nextInt();

            animalMedals[j] = new Medal(z, tournament, year);

        }

        Point myPoint = new Point(0, 0);

        System.out.println("Please enter " + animal + "'s wingspan: ");
        double wingspan = userInput.nextDouble();

        System.out.println("Please enter " + animal + "'s family: ");
        String family = userInput.next();

        return new Pigeon(family, wingspan, animalName, gender, animalWeight, animalSpeed, animalMedals, myPoint);
    }

    /*
    this function creates an instance of a Eagle with the required Eagle's information
    @return Eagle's instance.
     */
    private static Eagle createEagle() {
        String animal = "Eagle";

        //scanner object.
        Scanner userInput = new Scanner(System.in);


        System.out.println("Please enter a name for the " + animal + ": ");
        String animalName = userInput.next();

        System.out.println("Please choose the Gender of the " + animal + ":\n(*) for Male - press 1.\n(*) for Female - press 2.\n(*) for Hermaphrodite - press 3. ");
        int animalGender_key = userInput.nextInt();
        String animalGender = null;
        switch (animalGender_key) {
            case 1:
                animalGender = "Male";
                break;
            case 2:
                animalGender = "Female";
                break;
            case 3:
                animalGender = "Hermaphrodite";
                break;
            default:
                System.out.println("bad pick! try again.");
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
            System.out.println("wrong input! atone!");
            System.exit(0);
        }

        gender = Gender.valueOf(animalGender);

        System.out.println("Please enter the weight of the " + animal + ": ");
        double animalWeight = userInput.nextDouble();

        System.out.println("Please enter the speed of the " + animal + ": ");
        double animalSpeed = userInput.nextDouble();

        System.out.println("How many medals the " + animal + " has: ");
        int amountOfMedals = userInput.nextInt();

        //creating an array of pointers to Medal.
        Medal[] animalMedals = new Medal[amountOfMedals];

        for (int j = 0; j < amountOfMedals; ++j) {
            System.out.println("Which medal " + animal + " have:\n(*) Gold - press 1.\n(*) Silver - press 2.\n(*) Bronze - press 3. ");
            int animalMedal_key = userInput.nextInt();
            String val = null;
            switch (animalMedal_key) {
                case 1:
                    val = "gold";
                    break;
                case 2:
                    val = "silver";
                    break;
                case 3:
                    val = "bronze";
                    break;
                default:
                    System.out.println("bad pick! try again.");
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
                System.out.println("wrong input! atone!");
                System.exit(0);
            }

            z = Medal.myMedal.valueOf(val);

            System.out.println("On which tournament he won?: ");
            String tournament = userInput.next();

            System.out.println("On which year it was?: ");
            int year = userInput.nextInt();

            animalMedals[j] = new Medal(z, tournament, year);

        }


        Point myPoint = new Point(0, 100);

        System.out.println("Please enter " + animal + "'s wingspan: ");
        double wingspan = userInput.nextDouble();

        System.out.println("Please enter " + animal + "'s altitude of flight: ");
        double altitude = userInput.nextDouble();

        return new Eagle(altitude, wingspan, animalName, gender, animalWeight, animalSpeed, animalMedals, myPoint);
    }

    /*
    this function creates an instance of a Dog with the required Dog's information
    @return Dog's instance.
     */
    public static Dog createDog() {
        String animal = "Dog";

        //scanner object.
        Scanner userInput = new Scanner(System.in);


        System.out.println("Please enter a name for the " + animal + ": ");
        String animalName = userInput.next();

        System.out.println("Please choose the Gender of the " + animal + ":\n(*) for Male - press 1.\n(*) for Female - press 2.\n(*) for Hermaphrodite - press 3. ");
        int animalGender_key = userInput.nextInt();
        String animalGender = null;
        switch (animalGender_key) {
            case 1:
                animalGender = "Male";
                break;
            case 2:
                animalGender = "Female";
                break;
            case 3:
                animalGender = "Hermaphrodite";
                break;
            default:
                System.out.println("bad pick! try again.");
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
            System.out.println("wrong input! atone!");
            System.exit(0);
        }

        gender = Gender.valueOf(animalGender);

        System.out.println("Please enter the weight of the " + animal + ": ");
        double animalWeight = userInput.nextDouble();

        System.out.println("Please enter the speed of the " + animal + ": ");
        double animalSpeed = userInput.nextDouble();

        System.out.println("How many medals the " + animal + " has: ");
        int amountOfMedals = userInput.nextInt();

        //creating an array of pointers to Medal.
        Medal[] animalMedals = new Medal[amountOfMedals];

        for (int j = 0; j < amountOfMedals; ++j) {
            System.out.println("Which medal " + animal + " have:\n(*) Gold - press 1.\n(*) Silver - press 2.\n(*) Bronze - press 3. ");
            int animalMedal_key = userInput.nextInt();
            String val = null;
            switch (animalMedal_key) {
                case 1:
                    val = "gold";
                    break;
                case 2:
                    val = "silver";
                    break;
                case 3:
                    val = "bronze";
                    break;
                default:
                    System.out.println("bad pick! try again.");
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
                System.out.println("wrong input! atone!");
                System.exit(0);
            }

            z = Medal.myMedal.valueOf(val);

            System.out.println("On which tournament he won?: ");
            String tournament = userInput.next();

            System.out.println("On which year it was?: ");
            int year = userInput.nextInt();

            animalMedals[j] = new Medal(z, tournament, year);

        }

        Point myPoint = new Point(0, 20);

        System.out.println("how many legs the dog have?: ");
        int noLegs = userInput.nextInt();

        System.out.println("what is the dog's breed?: ");
        String breed = userInput.next();

        // initializing dog's info into the dog's instance.
        return new Dog(breed, noLegs, animalName, gender, animalWeight, animalSpeed, animalMedals, myPoint);
    }

    /*
    this function creates an instance of a Cat with the required Cat's information
    @return Cat's instance.
     */
    public static Cat createCat() {
        //scanner object.
        Scanner userInput = new Scanner(System.in);


        System.out.println("Please enter a name for the Cat: ");
        String catName = userInput.next();

        System.out.println("Please enter the Gender of the Cat: ");
        System.out.println("Please choose the Gender of the Cat :\n(*) for Male - press 1.\n(*) for Female - press 2.\n(*) for Hermaphrodite - press 3. ");
        int animalGender_key = userInput.nextInt();
        String animalGender = null;
        switch (animalGender_key) {
            case 1:
                animalGender = "Male";
                break;
            case 2:
                animalGender = "Female";
                break;
            case 3:
                animalGender = "Hermaphrodite";
                break;
            default:
                System.out.println("bad pick! try again.");
        }

        boolean flag = false;
        Gender y;

        //let's check if the string is included in the enum set.
        for (Gender x : Gender.values()) {
            if (x.name().equals(animalGender)) {
                flag = true;
                break;
            }
        }

        if (!flag) {
            System.out.println("wrong input! atone!");
            System.exit(0);
        }

        y = Gender.valueOf(animalGender);

        System.out.println("Please enter the weight of the Cat: ");
        double catWeight = userInput.nextDouble();

        System.out.println("Please enter the speed of the Cat: ");
        double catSpeed = userInput.nextDouble();

        System.out.println("How many medals the Cat has: ");
        int amountOfMedals = userInput.nextInt();

        //creating an array of pointers to Medal.
        Medal[] catsMedals = new Medal[amountOfMedals];

        for (int j = 0; j < amountOfMedals; ++j) {
            System.out.println("Which medal Cat have:\n(*) Gold - press 1.\n(*) Silver - press 2.\n(*) Bronze - press 3. ");
            int animalMedal_key = userInput.nextInt();
            String val = null;
            switch (animalMedal_key) {
                case 1:
                    val = "gold";
                    break;
                case 2:
                    val = "silver";
                    break;
                case 3:
                    val = "bronze";
                    break;
                default:
                    System.out.println("bad pick! try again.");
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
                System.out.println("wrong input! atone!");
                System.exit(0);
            }

            z = Medal.myMedal.valueOf(val);

            System.out.println("On which tournament he won?: ");
            String tournament = userInput.next();

            System.out.println("On which year it was?: ");
            int year = userInput.nextInt();

            catsMedals[j] = new Medal(z, tournament, year);

        }


        Point myPoint = new Point(0, 20);

        System.out.println("how many legs the Cat have?: ");
        int noLegs = userInput.nextInt();

        System.out.println("Is the cat castrated?: ");
        boolean castrated = userInput.nextBoolean();

        // initializing Cat's info into the Cat's instance.
        return new Cat(castrated, noLegs, catName, y, catWeight, catSpeed, catsMedals, myPoint);
    }

    /*
    this function creates an instance of a Snake with the required Snake's information
    @return Snake's instance.
     */
    public static Snake createSnake() {
        //scanner object.
        Scanner userInput = new Scanner(System.in);

        System.out.println("Please enter a name for the Snake: ");
        String snakeName = userInput.next();

        System.out.println("Please choose the Gender of the Snake:\n(*) for Male - press 1.\n(*) for Female - press 2.\n(*) for Hermaphrodite - press 3. ");
        int animalGender_key = userInput.nextInt();
        String animalGender = null;

        switch (animalGender_key) {
            case 1:
                animalGender = "Male";
                break;
            case 2:
                animalGender = "Female";
                break;
            case 3:
                animalGender = "Hermaphrodite";
                break;
            default:
                System.out.println("bad pick! try again.");
        }

        boolean flag = false;
        Gender y;

        //let's check if the string is included in the enum set.
        for (Gender x : Gender.values()) {
            if (x.name().equals(animalGender)) {
                flag = true;
                break;
            }
        }

        if (!flag) {
            System.out.println("wrong input! atone!");
            System.exit(0);
        }

        y = Gender.valueOf(animalGender);

        System.out.println("Please enter the weight of the Snake: ");
        double snakeWeight = userInput.nextDouble();

        System.out.println("Please enter the speed of the Snake: ");
        double snakeSpeed = userInput.nextDouble();
        while ((int) snakeSpeed > 5) {
            System.out.println("Snake's speed cannot be more than 5 km/h, please change the input:");
            snakeSpeed = userInput.nextDouble();
        }

        System.out.println("How many medals the Snake has: ");
        int amountOfMedals = userInput.nextInt();

        //creating an array of pointers to Medal.
        Medal[] snakeMedals = new Medal[amountOfMedals];

        for (int j = 0; j < amountOfMedals; ++j) {
            System.out.println("Which medal Snake have:\n(*) Gold - press 1.\n(*) Silver - press 2.\n(*) Bronze - press 3. ");
            int animalMedal_key = userInput.nextInt();
            String val = null;
            switch (animalMedal_key) {
                case 1:
                    val = "gold";
                    break;
                case 2:
                    val = "silver";
                    break;
                case 3:
                    val = "bronze";
                    break;
                default:
                    System.out.println("bad pick! try again.");
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
                System.out.println("wrong input! atone!");
                System.exit(0);
            }

            z = Medal.myMedal.valueOf(val);

            System.out.println("On which tournament he won?: ");
            String tournament = userInput.next();

            System.out.println("On which year it was?: ");
            int year = userInput.nextInt();

            snakeMedals[j] = new Medal(z, tournament, year);

        }

        Point myPoint = new Point(0, 20);

        System.out.println("Is the Snake poisonous?\n(*) Yes - press 1.\n(*) No - press 2.\n");
        int poison_key = userInput.nextInt();
        String val = null;
        switch (poison_key) {
            case 1:
                val = "YES";
                break;
            case 2:
                val = "NO";
                break;
            default:
                System.out.println("bad pick! try again.");
        }

        flag = false;
        Snake.Poisonous poisonPick;

        //let's check if the string is included in the enum set.
        for (Snake.Poisonous x : Snake.Poisonous.values()) {
            if (x.name().equals(val)) {
                flag = true;
                break;
            }
        }

        if (!flag) {
            System.out.println("wrong input! atone!");
            System.exit(0);
        }

        poisonPick = Snake.Poisonous.valueOf(val);


        System.out.println("Please enter the length of the snake: ");
        double length = userInput.nextDouble();

        // initializing Snake's info into the Cat's instance.
        return new Snake(poisonPick, length, 0, snakeName, y, snakeWeight, snakeSpeed, snakeMedals, myPoint);
    }
}



