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
this class represent a Cat, it derived from TerrestrialAnimals
 */
public class Cat extends TerrestrialAnimals {
    protected boolean castrated;


    /*
    default Cat constructor:
     */
    public Cat() {
        super(0, null, null, 0.0, 0.0, null, new Point(0,20));
        this.castrated = true;
    }

    /*
        (*) this is the Cat constructor (*)

        @param: noLegs gives the number of legs of the animal
        @param: name gives the name of the animal
        @param: valGender gives the Gender of the animal
        @param: weight gives the weight of the animal
        @param: speed gives the speed of the animal
        @param: medal gives an array of references to Medal
        @param: position gives the position of the animal
        @param: castrated gives us the enum value that represent is the cat is castrated or not.

    */
    public Cat(boolean castrated, int noLegs, String name, Gender valGender, double weight, double speed, Medal[] medal, Point position) {
        super(noLegs, name, valGender, weight, speed, medal, position);
        this.castrated = castrated;

    }


    public Boolean makeSound () {
            System.out.println("Animal " + this.name + " said Meow.");
            return true;
        }


    /*
    this function will give us all the information regard the animal
    @return: a String of the animal's information
     */
    public String toString() {

        return "*** CAT'S INFORMATION ***:\n" + super.toString() + "\n(*) Number of legs: " + this.noLegs + "." +
                "\n(*) Castrated: " + this.castrated + ".\n\n";
    }

}
