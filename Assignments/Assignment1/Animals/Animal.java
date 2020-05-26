/*
package used - Animals
 */
package Animals;

/*
relevant imports: Mobility.Mobile, Mobility.Point, Olympics.Medal
 */

import Mobility.ILocatable;
import Mobility.Mobile;
import Mobility.Point;
import Olympics.Medal;
import graphics.IClonable;
import graphics.IDrawable;
import graphics.IMoveable;

import java.awt.*;

/*
this class is an abstract class which is representing all animals
it's a derived class of Mobile.
 */
public abstract class Animal extends Mobile implements ILocatable {
    protected Gender myGender;
    protected String name;
    protected Double weight;
    protected Double speed;
    protected Medal[] medal;
    protected Point position;


//    protected int size;
//    protected int id;
//    protected Location loc;
//    protected Orientation orien;
//    protected int maxEnergy;
//    protected int energyPerMeter;
//    protected CompetitionPanel pan;
//    protected BufferedImage img1, img2, img3, img4;

    /*
    (*) this is the Animal constructor (*)

    @param: name gives the name of the animal
    @param: valGender gives the Gender of the animal
    @param: weight gives the weight of the animal
    @param: speed gives the speed of the animal
    @param: medal gives an array of references to Medal
    @param: position gives the position of the animal
     */

    Animal(String name, Gender valGender, double weight, double speed, Medal[] medal, Point position) {
        super(position);

        // checking if the type is right
        if (name != null) {
            if (((Object) name).getClass().getName().equals("java.lang.String")) {
                this.name = name;
            }
        }
        this.myGender = valGender;
        // checking if the type is right

        if (((Object) weight).getClass().getName().equals("java.lang.Double") && weight > 0.0){
            this.weight = weight;
        } else {
            System.out.println("wrong input! atone!");
        }


        // checking if the type is right

        if (((Object) speed).getClass().getName().equals("java.lang.Double") && speed >= 0.0) {
            this.speed = speed;
        } else {
            System.out.println("wrong input! atone!");
        }


        this.position = new Point(position.x, position.y);
        if (medal != null) {

            this.medal = new Medal[medal.length];
            for (int i = 0; i < medal.length; ++i) {
                this.medal[i] = new Medal(medal[i].medal, medal[i].tournament, medal[i].year);
            }
        } else {
            this.medal = null;
        }
    }

    /*
    this function will return the location of the animal
    @return: this.location
     */
    @Override
    public Point getLocation() {
        return this.position;
    }

    /*
    this function will set the new location of the animal
    @param: other gives us the new coordinates of the animal
    @return: true/false
    */
    @Override
    public boolean setLocation(Point other) {
        if (this.position.x == other.x && this.position.y == other.y) {
            return false;
        }
        this.position.x = other.x;
        this.position.y = other.y;
        return true;
    }

    /*
    this function will add additional distance to the distance we already have.
    @param: distanceToAdd gives us the additional distance
     */
    @Override
    public Boolean addTotalDistance(double distanceToAdd) {
        this.totalDistance += distanceToAdd;
        return false;
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
    this function will make the required animal sound
     */
    abstract public Boolean makeSound ();

    public String toString() {
        StringBuilder totalMedal = null;
        if (this.medal != null) {
            totalMedal = new StringBuilder("\n* MEDALS INFORMATION: *\n\n");
            for (Medal value : this.medal) {
                totalMedal.append(value.toString());
                totalMedal.append("\n");
            }
        } else {
            totalMedal = new StringBuilder("no medal.");
        }
        return "(*) Name: " + this.name + ".\n(*) Gender: " + this.myGender + ".\n(*) Weight: " + this.weight + " kilograms." +
                "\n(*) Speed: " + this.speed + " km/h.\n" + totalMedal + "\n(*) " + this.location.toString();
    }


}
