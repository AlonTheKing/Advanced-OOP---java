/*
package - Animals
 */
package Animals;

/*
relevant imports: Mobility.Point, Olympics.Medal
 */

import Mobility.Point;
import Olympics.Medal;

/*
this class represent a Dog, which is derived from TerrestrialAnimals
 */
public class Dog extends TerrestrialAnimals {
    protected String breed;

    /*
    default Dog constructor:
     */
    public Dog() {
        super(0, null, null, 0.0, 0.0, null, new Point(0, 20));
        this.breed = null;
    }
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

    public Dog(String breed, int noLegs, String name, Gender valGender, double weight, double speed, Medal[] medal, Point position) {
        super(noLegs, name, valGender, weight, speed, medal, position);
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

        return "*** DOG'S INFORMATION ***:\n" + super.toString() +  "(*) Number of legs: " + this.noLegs + "." +
                "\n(*) Breed: " + this.breed + ".\n\n";
    }


}

