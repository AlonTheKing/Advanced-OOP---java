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
this class represent a Dolphin, which is derived from WaterAnimal
 */
public class Dolphin extends WaterAnimal {
    public enum WaterType {
        Sea, Sweet;
    }

    protected WaterType dolType;

    /*
    default Dolphin constructor:
     */
    public Dolphin() {
        super(0, null, null, 0.0, 0.0, null, new Point(0,20));
        this.dolType = null;
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
    @param: dilType gives us the type of water our dolphin lives in

*/
    public Dolphin(WaterType dolType, double diveDept, String name, Gender valGender, double weight, double speed, Medal[] medal, Point position) {
        super(diveDept, name, valGender, weight, speed, medal, position);
        this.dolType = dolType;
    }

    public Boolean makeSound () {
        System.out.println("Animal " + this.name + " said Click-click.");
        return true;
    }

    /*
    this function will give us all the information regard the animal
    @return: a String of the animal's information
     */
    public String toString() {

        return "*** DOLPHIN'S INFORMATION ***:\n" + super.toString() +  "(*) Dive depth: " + this.diveDepth + "." +
                "\n(*) Water type: " + this.dolType + ".\n\n";
    }

}
