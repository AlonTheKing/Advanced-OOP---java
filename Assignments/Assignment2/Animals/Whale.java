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
this class represent a Whale, which is derived from WaterAnimal
 */
public class Whale extends WaterAnimal {
    protected String foodType;

    /*
    (*) this is the Dolphin constructor (*)

    @param: name gives the name of the animal
    @param: valGender gives the Gender of the animal
    @param: weight gives the weight of the animal
    @param: speed gives the speed of the animal
    @param: medal gives an array of references to Medal
    @param: position gives the position of the animal
    @param: diveDepth gives us dive depth of the animal
    @param: foodType gives us the food type that our animal loves to eat

*/
    public Whale(String foodType, double diveDept, String name, Gender valGender, Double weight, Double speed, Medal[] medal, Point position, String animalCategory, String skin,int energy, int energyPerMeter) throws IOException {
        super(diveDept, name, valGender, weight, speed, medal, position,animalCategory,skin,energy,energyPerMeter);
        this.foodType = foodType;
    }

    public Boolean makeSound () {
        System.out.println("Animal " + this.name + " said Splash.");
        return true;
    }

    /*
    this function will give us all the information regard the animal
    @return: a String of the animal's information
     */
    public String toString() {

        return "*** WHALE'S INFORMATION ***:\n" + super.toString() +  "\n(*) Dive depth: " + this.diveDepth + "." +
                "\n(*) Food type: " + this.foodType + ".\n\n";
    }
}