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
this class represent an Eagle, which is derived from AirAnimals
 */
public class Eagle extends AirAnimal {
    protected double altitudeOfFlight;
    public static final int MAX_ALTITUDE = 1000;

    /*
    default Eagle constructor:
     */
    public Eagle() {
        super(0, null, null, 0.0, 0.0, null, new Point(0,20));
        this.altitudeOfFlight = 0.0;
    }

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
    public Eagle(double altitudeOdFlight, double wingspan, String name, Gender valGender, double weight, double speed, Medal[] medal, Point position) {
        super(wingspan, name, valGender, weight, speed, medal, position);
        if (altitudeOdFlight < MAX_ALTITUDE) {
            this.altitudeOfFlight = altitudeOdFlight;
        } else {
            System.out.println("wrong altitude! atone!");
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
        return Math.sqrt(Math.pow(other.x, 2) + Math.pow(other.y, 2));
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
                "\n(*) Speed: " + this.speed + " km/h.\n" + totalMedal + "\n(*) " + this.location.toString() + "(*) Wing span: " + this.wingspan + "." +
                "\n(*) Altitude of flight: " + this.altitudeOfFlight + ".\n\n";
    }
}
