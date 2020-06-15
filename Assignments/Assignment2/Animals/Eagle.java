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
this class represent an Eagle, which is derived from AirAnimals
 */
public class Eagle extends AirAnimal {
    protected double altitudeOfFlight;
    public static final int MAX_ALTITUDE = 1000;

    /*
        (*) this is the Eagle constructor (*)

        @param: name gives the name of the animal
        @param: valGender gives the Gender of the animal
        @param: weight gives the weight of the animal
        @param: speed gives the speed of the animal
        @param: medal gives an array of references to Medal
        @param: position gives the position of the animal
        @param: wingspan gives us wing span of the animal
        @param: altitudeOfFlight give us the animal's altitude of flight

    */
    public Eagle(double altitudeOdFlight, double wingspan, String name, Gender valGender, double weight, double speed, Medal[] medal, Point position, String animalCategory, String skin, int energy, int energyPerMeter) throws IOException {
        super(wingspan, name, valGender, weight, speed, medal, position, animalCategory, skin, energy, energyPerMeter);
        if (altitudeOdFlight < MAX_ALTITUDE) {
            this.altitudeOfFlight = altitudeOdFlight;
        } else {
            System.out.println("wrong altitude! atone!");
        }
    }

    public Boolean makeSound () {
        System.out.println("Animal " + this.name + " said Clack-wack-chack.");
        return true;
    }

    /*
    this function will give us all the information regard the animal
    @return: a String of the animal's information
     */
    public String toString() {

        return "*** EAGLE'S INFORMATION ***:\n" + super.toString()  + "(*) Wing span: " + this.wingspan + "." +
                "\n(*) Altitude of flight: " + this.altitudeOfFlight + ".\n\n";
    }
}
