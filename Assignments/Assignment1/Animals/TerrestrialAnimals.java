package Animals;

import Mobility.Point;
import Olympics.Medal;

public abstract class TerrestrialAnimals extends Animal {
    // x = 0, y = 20 (point)
    protected int noLegs;


    public TerrestrialAnimals(int noLegs, String name, Gender valGender, Double weight, Double speed, Medal[] medal, Point position) {
        super(name, valGender, weight, speed, medal, position);
        if (noLegs >= 0.0) {
            this.noLegs = noLegs;
        } else {
            System.out.println("Wrong input! atone!");
        }
    }
}
