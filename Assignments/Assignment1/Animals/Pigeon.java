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
this class represent an Pigeon, which is derived from AirAnimals
 */
public class Pigeon extends AirAnimal {
    //x = 0, y = 0
    protected String family;

    /*
    default Pigeon constructor:
     */
    public Pigeon() {
        super(0, null, null, 0.0, 0.0, null, new Point(0,20));
        this.family = null;
    }


    /*
        (*) this is the Pigeon constructor (*)

        @param: name gives the name of the animal
        @param: valGender gives the Gender of the animal
        @param: weight gives the weight of the animal
        @param: speed gives the speed of the animal
        @param: medal gives an array of references to Medal
        @param: position gives the position of the animal
        @param: wingspan gives us wing span of the animal
        @param: family give us the animal's family

    */
    public Pigeon(String family, double wingspan, String name, Gender valGender, double weight, double speed, Medal[] medal, Point position) {
        super(wingspan, name, valGender, weight, speed, medal, position);

        this.family = family;
    }

    public Boolean makeSound () {
        System.out.println("Animal " + this.name + " said Arr-rar-rar-rar-raah.");
        return true;
    }

    /*
    this function will give us all the information regard the animal
    @return: a String of the animal's information
     */
    public String toString() {

        return "*** PIGEON'S INFORMATION ***:\n" + super.toString()  + "(*) Wing span: " + this.wingspan + "." +
                "\n(*) Family: " + this.family + ".\n\n";
    }
}


