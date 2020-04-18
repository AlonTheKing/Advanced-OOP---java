/*
package - Animals
 */
package Animals;

/*
imports: Mobility.Point, Olympics.Medal
 */

import Mobility.Point;
import Olympics.Medal;

/*
this class represent Alligator which is water animal, and implementing the IReptile interface.
 */
public class Alligator extends WaterAnimal implements IReptile {
    protected String areaOfLiving;

    /*
    default Alligator constructor:
     */
    public Alligator() {
        super(0, null, null, 0.0, 0.0, null, new Point(0,20));
        this.areaOfLiving = null;
    }

    /*
        (*) this is the Alligator constructor (*)

        @param: wingspan gives the wing span of the animal
        @param: name gives the name of the animal
        @param: valGender gives the Gender of the animal
        @param: weight gives the weight of the animal
        @param: speed gives the speed of the animal
        @param: medal gives an array of references to Medal
        @param: position gives the position of the animal
        @param: diveDepth gives the depth the animal can dive
        @param: areaOfLiving gives the animal's area of living

    */
    public Alligator(String areaOfLiving, double diveDept, String name, Gender valGender, double weight, double speed, Medal[] medal, Point position) {
        super(diveDept, name, valGender, weight, speed, medal, position);
        this.areaOfLiving = areaOfLiving;
    }

    /*
    this function is making the alligator to dive deeper, but not too deep.
    @param: deeper gives us how deep the alligator will dive.
     */
    @Override
    Boolean Dive(double deeper) {
        if (this.diveDepth - deeper < MAX_DIVE) {
            this.diveDepth -= deeper;
            return true;
        } else {
            System.out.println("too deep! atone!");
            return false;
        }
    }

    /*
    this function will return the location of the animal
    @return: this.location
     */
    @Override
    public Point getLocation() {
        return this.location;
    }

    /*
    this function will set the new location of the animal
    @param: other gives us the new coordinates of the animal
    @return: true/false
     */
    @Override
    public boolean setLocation(Point other) {
        if (this.location.x == other.x && this.location.y == other.y) {
            return false;
        }
        this.location.x = other.x;
        this.location.y = other.y;
        return true;
    }

    /*
    this function will add additional distance to the distance we already have.
    @param: distanceToAdd gives us the additional distance
     */
    @Override
    public Boolean addTotalDistance(double distanceToAdd) {
        this.totalDistance += distanceToAdd;
        return true;
    }

    /*
    this function will calculate the distance of our animal with another animal's location
    @param: other gives us the location of another animal
    @return: the distance between two locations
     */
    @Override
    public double calcDistance(Point other) {
        return Math.sqrt(Math.pow(other.x - this.location.x, 2) + Math.pow(other.y - this.location.y, 2));
    }

    /*
    this function will give us the distance the animal did from the starting point
    @param: other is our current position
    @return: the distance the animal did
     */
    @Override
    public double move(Point other) {
        return Math.sqrt(Math.pow(other.x, 2) + Math.pow(other.y - 20, 2));
    }

    /*
    this function will speed the reptile's movement
    @param: speedToAdd gives us the additional speed
    @return the new speed
     */
    @Override
    public double speedUp(int speedToAdd) {
        if (this.speed + speedToAdd > MAX_SPEED) {
            System.out.println("alligator cannot be faster than 5 km/h.");
            return this.speed;
        } else {
            this.speed += speedToAdd;
            return this.speed;
        }
    }

    /*
    this function will give us all the information regard the animal
    @return: a String of the animal's information
     */
    public String toString() {
        String totalMedal = null;
        if (this.medal != null) {
            totalMedal = "* MEDALS INFORMATION: *\n";
            for (int i = 0; i < this.medal.length; ++i) {
                totalMedal += this.medal[i].toString();
            }
        } else {
            totalMedal = "default medal.";
        }
        return "*** ALLIGATOR'S INFORMATION ***:\n(*) Name: " + this.name + ".\n(*) Gender: " + this.myGender + ".\n(*) Weight: " + this.weight + " kilograms." +
                "\n(*) Speed: " + this.speed + " km/h.\n" + totalMedal + "\n(*) " + this.location.toString() + "(*) Dive depth: " + this.diveDepth + "." +
                "\n(*) Area of living: " + this.areaOfLiving + ".\n\n";
    }

}
