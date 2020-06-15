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
    public WaterAnimal(double diveDepth, String name, Gender valGender, double weight, double speed, Medal[] medal, Point position, String animalCategory, String skin,int energy, int energyPerMeter) throws IOException {
        super(name, valGender, weight, speed, medal, position,animalCategory,skin,energy,energyPerMeter);
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
    Boolean Dive(double deeper) {
        if (this.diveDepth - deeper < MAX_DIVE) {
            this.diveDepth -= deeper;
            return true;
        } else {
            System.out.println("too deep! atone!");
            return false;
        }
    }
    public String getType(){return "Water Animal";}

    public int getCurrEnergy(){return this.currEnergy;}
    public void setCurrEnergy(int x)
    {
        if (this.maxEnergy > this.currEnergy+x)
            this.currEnergy = x;
        else {
            throw new RuntimeException("above max energy");
        }
    }

    public void setEnergyPerMeter(int x){
        this.energyPerMeter = x;
    }
}
