/*
package - Mobility
 */
package Mobility;


/*
this abstract class represent a Mobile, and implement the interface ILocatable
 */
public abstract class Mobile implements ILocatable{
    public Point location;
    protected double totalDistance;

    /*
    *** Mobile Constructor ***
    @param other give us a location to initialize the animal's location with
     */
    public Mobile(Point other){
        this.location = new Point(other.x, other.y);
        this.totalDistance = 0;
    }
    /*
    this function will add additional distance to the distance we already have.
    @param: distanceToAdd gives us the additional distance
     */
    public abstract Boolean addTotalDistance(double x);

    /*
    this function will calculate the distance of our animal with another animal's location
    @param: other gives us the location of another animal
    @return: the distance between two locations
     */
    public abstract double calcDistance(Point other);

    /*
    this function will give us the distance the animal did from the starting point
    @param: other is our current position
    @return: the distance the animal did
     */
    public abstract double move(Point other);

}
