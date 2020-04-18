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
this class represent a Water animals, which is derived from Animal
 */
public abstract class WaterAnimal extends Animal{
    ///x = 50, y = 0
    protected static final int MAX_DIVE = -800;
    protected double diveDepth;

    /*
    (*) this is the WaterAnimal constructor (*)

    @param: name gives the name of the animal
    @param: valGender gives the Gender of the animal
    @param: weight gives the weight of the animal
    @param: speed gives the speed of the animal
    @param: medal gives an array of references to Medal
    @param: position gives the position of the animal
    @param: diveDepth gives us dive depth of the animal

*/
    public WaterAnimal(double diveDepth, String name, Gender valGender, double weight, double speed, Medal[] medal, Point position){
        super(name, valGender, weight, speed, medal, position);
        if(diveDepth >0){
            System.out.println("wrong input of dive depth, initialized to 0");
            this.diveDepth = 0;
        }
        else {
            this.diveDepth = diveDepth;
        }
    }

    /*
    this function makes the animals to dive deeper
    @param: deeper give us the depth we need to add to our current depth
     */
    abstract Boolean Dive(double deeper);

}
