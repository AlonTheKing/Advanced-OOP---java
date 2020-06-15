package Animals;

import Mobility.Point;
import Olympics.Medal;

import java.io.IOException;

public abstract class TerrestrialAnimals extends Animal {
    // x = 0, y = 20 (point)
    protected int noLegs;


    public TerrestrialAnimals(int noLegs, String name, Gender valGender, Double weight, Double speed, Medal[] medal, Point position, String animalCategory, String skin, int energy, int energyPerMeter) throws IOException {
        super(name, valGender, weight, speed, medal, position, animalCategory, skin, energy, energyPerMeter);
        if (noLegs >= 0.0) {
            this.noLegs = noLegs;
        } else {
            System.out.println("Wrong input! atone!");
        }
    }

    public String getType() {
        return "Terrestrial Animal";
    }

    public int getCurrEnergy() {
        return this.currEnergy;
    }

    public void setCurrEnergy(int x) {
        if (this.maxEnergy > this.currEnergy + x)
            this.currEnergy = x;
        else {
            throw new RuntimeException("above max energy");
        }
    }

    public void setEnergyPerMeter(int x) {
        this.energyPerMeter = x;
    }


}
