///*
//
// *****************************
// *****************************
// ** NAME: David charon-zade **
// ** ID: 312797426           **
// *****************************
// *****************************
// */

/*
package - java.lang.System
 */
package system;

/*
imports:java.util.*, Animals.*, Mobility.Point, Olympics.Medal
 */

import java.io.IOException;
import java.util.*;

import Animals.*;
import graphics.CompetitionFrame;

/*m.
 */
//this class represents the system
//public class System {
//    /*
//    this static point is our's java.lang.System starting point
//     */
//    public static void main(String[] args) throws IOException {

//
//
////
////
////        int i = 0;
////        // creating a reference to a scanner for user input.
////        Scanner userInput = new Scanner(java.lang.System.in);
////
////        java.lang.System.out.println("Enter how many Animals would you like to create?");
////
////        //getting a size of the user (int).
////        int numOfAnimals = userInput.nextInt();
////
////        // array of Animals pointers.
////        Animal[] myAnimal = new Animal[numOfAnimals];
////
////        while (i < numOfAnimals) {
////            java.lang.System.out.println("Please choose, which of the following Animal types you'd like to create:\n(*) Terrestrial Animal - Press 1.\n(*) Air Animal - Press 2.\n(*) Water Animal - Press 3.");
////
////            //getting a user input.
////            int animalTypeSelection = userInput.nextInt();
////
////            //switch case to test the validation of the input.
////            //Terrestrial animal.
////            //getting input from the user. (int)
////            //Air animal.
////            //Water animal.
////            switch (animalTypeSelection) {
////                case 1 -> {
////                    java.lang.System.out.println("Please choose which of the following Terrestrial Animals would you like to have:\n(*) Dog - Press 1.\n(*) Cat- Press 2.\n(*) Snake - Press 3.\n(*) Alligator - press 4.");
////                    int terrestrialSelection = userInput.nextInt();
////                    switch (terrestrialSelection) {
////                        case 1 -> {
////                            myAnimal[i] = createDog();
////                            i += 1;
////                        }
////                        case 2 -> {
////                            myAnimal[i] = createCat();
////                            i += 1;
////                        }
////                        case 3 -> {
////                            myAnimal[i] = createSnake();
////                            i += 1;
////                        }
////                        case 4 -> {
////                            myAnimal[i] = createAlligator();
////                            i += 1;
////                        }
////                        default -> java.lang.System.out.println("you have chosen poorly, atone! ");
////                    }
////                }
////                case 2 -> {
////                    java.lang.System.out.println("Please choose which of the following Air Animals would you like to have:\n(*) Eagle - Press 1.\n(*) Pigeon - Press 2.");
////                    int airSelection = userInput.nextInt();
////                    // create another switch for -> toString (all the info regard the animal), makeSound, exit the java.lang.System
////                    // create another switch for -> toString (all the info regard the animal), makeSound, exit the java.lang.System
////                    switch (airSelection) {
////                        case 1 -> {
////                            myAnimal[i] = createEagle();
////                            i += 1;
////                        }
////                        case 2 -> {
////                            myAnimal[i] = createPigeon();
////                            i += 1;
////                        }
////                        default -> java.lang.System.out.println("you have chosen poorly, atone! ");
////                    }
////                }
////                case 3 -> {
////                    java.lang.System.out.println("Please choose which of the following Water Animals would you like to have:\n(*) Alligator - Press 1.\n(*) Whale  - Press 2.\n(*) Dolphin - press 3.");
////                    int waterSelection = userInput.nextInt();
////                    switch (waterSelection) {
////                        case 1 -> {
////                            myAnimal[i] = createAlligator();
////                            i += 1;
////                        }
////                        case 2 -> {
////                            myAnimal[i] = createWhale();
////                            i += 1;
////                        }
////                        case 3 -> {
////                            myAnimal[i] = createDolphin();
////                            i += 1;
////                        }
////                        default -> java.lang.System.out.println("you have chosen poorly, atone! ");
////                    }
////                }
////                default -> java.lang.System.out.println("you have chosen poorly, atone! ");
////            }
////        }
////
////        userMenu(myAnimal);
////    }
////
////    /*
////    this function gives the user the menu about the operations he can do with the zoo he created.
////    @param: myZoo is the array of animals that the user created
////     */
////    public static void userMenu(Animal[] myZoo) {
////
////        java.lang.System.out.println("*** Please choose of on the following options: ***\n(*) Information about the animals that you created - press 1.\n(*) Sound of each animal you created - press 2.\n(*) To exit - press 3.\n");
////        Scanner userInput = new Scanner(java.lang.System.in);
////        int key = userInput.nextInt();
////
////        switch (key) {
////            case 1:
////                for (Animal animal : myZoo) {
////                    java.lang.System.out.println(animal.toString());
////                }
////                break;
////            case 2:
////                for (Animal animal : myZoo) {
////                    animal.makeSound();
////                }
////                break;
////            case 3:
////                java.lang.System.out.println("Thank you.");
////                java.lang.System.exit(1);
////                break;
////
////            default:
////                java.lang.System.out.println("Invalid choice! atone!\n");
////                break;
////        }
////    }
////
////
////    /*
////    this function creates an instance of a Dolphin with the required Dolphin's information
////    @return Dolphin's instance.
////     */
////    private static Dolphin createDolphin() {
////
////        String animal = "Dolphin";
////        Scanner userInput = new Scanner(java.lang.System.in);
////        boolean flag = false;
////
////        CreateAnimal myAnimal = new CreateAnimal(animal);
////
////        java.lang.System.out.println("Please enter " + animal + "'s dive depth:");
////        double diveDepth = userInput.nextDouble();
////
////        java.lang.System.out.println("In which water the " + animal + " lives?: ");
////        java.lang.System.out.println("1. sea water - press 1.\n2. sweet water - press 2. ");
////        int dolType = userInput.nextInt();
////        Dolphin.WaterType z;
////        String dolTypeString = "";
////
////
////        switch (dolType) {
////            case 1 -> dolTypeString = "Sea";
////            case 2 -> dolTypeString = "Sweet";
////            default -> dolTypeString = "";
////        }
////
////
////        //let's check if the string is included in the enum set.
////        for (Dolphin.WaterType x : Dolphin.WaterType.values()) {
////            if (x.name().equals(dolTypeString)) {
////                flag = true;
////                break;
////            }
////        }
////
////        if (!flag) {
////            java.lang.System.out.println("wrong input! atone!");
////            java.lang.System.exit(0);
////        }
////
////        z = Dolphin.WaterType.valueOf(dolTypeString);
////
////
////        return new Dolphin(z, diveDepth, myAnimal.getName(), myAnimal.getMyGender(), myAnimal.getWeight(), myAnimal.getSpeed(), myAnimal.getMedal(), myAnimal.getPosition());
////    }
////
////    /*
////    this function creates an instance of a Whale with the required Whale's information
////    @return Whale's instance.
////     */
////    private static Whale createWhale() {
////        String animal = "Whale";
////
////        //scanner object.
////        Scanner userInput = new Scanner(java.lang.System.in);
////        CreateAnimal myAnimal = new CreateAnimal(animal);
////
////
////        java.lang.System.out.println("Please enter " + animal + "'s dive depth:");
////        double diveDepth = userInput.nextDouble();
////
////        java.lang.System.out.println("Please enter " + animal + "'s food type: ");
////        String foodType = userInput.next();
////
////        return new Whale(foodType, diveDepth, myAnimal.getName(), myAnimal.getMyGender(), myAnimal.getWeight(), myAnimal.getSpeed(), myAnimal.getMedal(), myAnimal.getPosition());
////
////    }
////
////    /*
////    this function creates an instance of a Alligator with the required Alligator's information
////    @return Alligator's instance.
////     */
////    private static Alligator createAlligator() {
////        String animal = "Alligator";
////        //scanner object.
////        Scanner userInput = new Scanner(java.lang.System.in);
////        CreateAnimal myAnimal = new CreateAnimal(animal);
////
////        java.lang.System.out.println("how many legs the " + animal + " have?: ");
////        int noLegs = userInput.nextInt();
////
////
////        java.lang.System.out.println("Please enter " + animal + "'s dive depth:");
////        double diveDepth = userInput.nextDouble();
////
////        java.lang.System.out.println("Please enter " + animal + "'s area of living: ");
////        String areaOfLiving = userInput.next();
////
////        return new Alligator(noLegs, areaOfLiving, diveDepth, myAnimal.getName(), myAnimal.getMyGender(), myAnimal.getWeight(), myAnimal.getSpeed(), myAnimal.getMedal(), myAnimal.getPosition());
////    }
////
////    /*
////    this function creates an instance of a Pigeon with the required Pigeon's information
////    @return Pigeon's instance.
////     */
////    private static Pigeon createPigeon() {
////        String animal = "Pigeon";
////
////        //scanner object.
////        Scanner userInput = new Scanner(java.lang.System.in);
////        CreateAnimal myAnimal = new CreateAnimal(animal);
////
////
////        java.lang.System.out.println("Please enter " + animal + "'s wingspan: ");
////        double wingspan = userInput.nextDouble();
////
////        java.lang.System.out.println("Please enter " + animal + "'s family: ");
////        String family = userInput.next();
////
////        return new Pigeon(family, wingspan, myAnimal.getName(), myAnimal.getMyGender(), myAnimal.getWeight(), myAnimal.getSpeed(), myAnimal.getMedal(), myAnimal.getPosition());
////    }
////
////    /*
////    this function creates an instance of a Eagle with the required Eagle's information
////    @return Eagle's instance.
////     */
////    private static Eagle createEagle() {
////        String animal = "Eagle";
////
////        //scanner object.
////        Scanner userInput = new Scanner(java.lang.System.in);
////        CreateAnimal myAnimal = new CreateAnimal(animal);
////
////
////        java.lang.System.out.println("Please enter " + animal + "'s wingspan: ");
////        double wingspan = userInput.nextDouble();
////
////        java.lang.System.out.println("Please enter " + animal + "'s altitude of flight: ");
////        double altitude = userInput.nextDouble();
////
////        return new Eagle(altitude, wingspan, myAnimal.getName(), myAnimal.getMyGender(), myAnimal.getWeight(), myAnimal.getSpeed(), myAnimal.getMedal(), myAnimal.getPosition());
////    }
////
////    /*
////    this function creates an instance of a Dog with the required Dog's information
////    @return Dog's instance.
////     */
////    public static Dog createDog() {
////        String animal = "Dog";
////
////        //scanner object.
////        Scanner userInput = new Scanner(java.lang.System.in);
////        CreateAnimal myAnimal = new CreateAnimal(animal);
////
////        java.lang.System.out.println("how many legs the " + animal + " have?: ");
////        int noLegs = userInput.nextInt();
////
////        java.lang.System.out.println("what is the " + animal + "s breed?: ");
////        String breed = userInput.next();
////
////        // initializing dog's info into the dog's instance.
////        return new Dog(breed, noLegs, myAnimal.getName(), myAnimal.getMyGender(), myAnimal.getWeight(), myAnimal.getSpeed(), myAnimal.getMedal(), myAnimal.getPosition());
////    }
////
////    /*
////    this function creates an instance of a Cat with the required Cat's information
////    @return Cat's instance.
////     */
////    public static Cat createCat() {
////        //scanner object.
////        String animal = "cat";
////        Scanner userInput = new Scanner(java.lang.System.in);
////        CreateAnimal myAnimal = new CreateAnimal(animal);
////
////        java.lang.System.out.println("how many legs the " + animal + " have?: ");
////        int noLegs = userInput.nextInt();
////
////        java.lang.System.out.println("Is the " + animal + " castrated?: (*) Yes - press 1\n(*) No - press 2");
////
////        int castrated = userInput.nextInt();
////        boolean bool_castrated = false;
////        switch (castrated) {
////            case 1: {
////                bool_castrated = true;
////            }
////            case 2: {
////                bool_castrated = false;
////            }
////            default: {
////                java.lang.System.out.println("wrong pick!");
////            }
////        }
////
////
////        // initializing Cat's info into the Cat's instance.
////        return new Cat(bool_castrated, noLegs, myAnimal.getName(), myAnimal.getMyGender(), myAnimal.getWeight(), myAnimal.getSpeed(), myAnimal.getMedal(), myAnimal.getPosition());
////    }
////
////    /*
////    this function creates an instance of a Snake with the required Snake's information
////    @return Snake's instance.
////     */
////    public static Snake createSnake() {
////        //scanner object.
////        String animal = "Snake";
////        Scanner userInput = new Scanner(java.lang.System.in);
////        CreateAnimal myAnimal = new CreateAnimal(animal);
////        boolean flag;
////
////        java.lang.System.out.println(animal +  "'s Toxicity?\n(*) High - press 1.\n(*) Medium - press 2.\n(*) Low - press 3.\n");
////        int poison_key = userInput.nextInt();
////        String val = null;
////        switch (poison_key) {
////            case 1 -> val = "High";
////            case 2 -> val = "Medium";
////            case 3 -> val = "Low";
////            default -> java.lang.System.out.println("bad pick! try again.");
////        }
////
////        flag = false;
////        Snake.Poisonous poisonPick;
////
////        //let's check if the string is included in the enum set.
////        for (Snake.Poisonous x : Snake.Poisonous.values()) {
////            if (x.name().equals(val)) {
////                flag = true;
////                break;
////            }
////        }
////
////        if (!flag) {
////            java.lang.System.out.println("wrong input! atone!");
////            java.lang.System.exit(0);
////        }
////
////        poisonPick = Snake.Poisonous.valueOf(val);
////
////
////        java.lang.System.out.println("Please enter the length of the snake: ");
////        double length = userInput.nextDouble();
////
////        // initializing Snake's info into the Cat's instance.
////        return new Snake(poisonPick, length, 0, myAnimal.getName(), myAnimal.getMyGender(), myAnimal.getWeight(), myAnimal.getSpeed(), myAnimal.getMedal(), myAnimal.getPosition());
//    }
//}
//
//
//
