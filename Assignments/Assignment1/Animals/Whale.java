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
this class represent a Whale, which is derived from WaterAnimal
 */
public class Whale extends WaterAnimal {
    String foodType;

    /*
    default Whale constructor:
     */
    public Whale() {
        super(0, null, null, 0.0, 0.0, null, new Point(0,20));
        this.foodType = null;
    }


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
    public Whale(String foodType, double diveDept, String name, Gender valGender, Double weight, Double speed, Medal[] medal, Point position) {
        super(diveDept, name, valGender, weight, speed, medal, position);
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

        return "*** WHALE'S INFORMATION ***:\n" + super.toString() +  "(*) Dive depth: " + this.diveDepth + "." +
                "\n(*) Food type: " + this.foodType + ".\n\n";
    }
}