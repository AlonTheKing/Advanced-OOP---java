/*
package - Animals
 */
package Mobility;
import Mobility.Point;

/*
this interface (ILocatable) is representing the location of our animals
 */
public interface ILocatable {
    Point getLocation();
    boolean setLocation(Point other);
}
