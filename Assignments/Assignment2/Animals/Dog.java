/*
package - Animals
 */
package Animals;

/*
relevant imports: Mobility.Point, Olympics.Medal
 */

import Mobility.Point;
import Olympics.Medal;

import java.io.IOException;

/*
this class represent a Dog, which is derived from TerrestrialAnimals
 */
public class Dog extends TerrestrialAnimals {
     protected String breed;

    /*
        (*) this is the Dog constructor (*)

        @param: noLegs gives the number of legs of the animal
        @param: name gives the name of the animal
        @param: valGender gives the Gender of the animal
        @param: weight gives the weight of the animal
        @param: speed gives the speed of the animal
        @param: medal gives an array of references to Medal
        @param: position gives the position of the animal
        @param: breed gives us breed of the animal

    */

    public Dog(String breed, int noLegs, String name, Gender valGender, double weight, double speed, Medal[] medal, Point position, String animalCategory, String skin,int energy, int energyPerMeter) throws IOException {
        super(noLegs, name, valGender, weight, speed, medal, position,animalCategory,skin,energy,energyPerMeter);
        this.breed = breed;
    }


    /*
    this function will give us all the information regard the animal
    @return: a String of the animal's information
     */

    public Boolean makeSound () {
        System.out.println("Animal " + this.name + " said Woof Woof.");
        return true;
    }
    public String toString() {

        return "*** DOG'S INFORMATION ***:\n" + super.toString() +  "\n(*) Number of legs: " + this.noLegs + "." +
                "\n(*) Breed: " + this.breed + ".\n\n";
    }


}

