/*
package - Mobility
 */
package Mobility;

/*
this class represents a Point
 */
public class Point {
    public int x;
    public int y;
    /*
    *** Point's Constructor ***
    @param: x is the x axis
    @param: y is the y axis
     */
    public Point(int x, int y) {
        if (x >= 0 && y >= 0) {
            this.x = x;
            this.y = y;
        } else {
            System.out.println("cannot initialize Point");
        }
    }
    /*
    this function gives us the string that represents a certain location on the graph
    @return: the (x,y) format location
     */
    public String toString(){
        return "* LOCATION: *\n\n(*) X: "+this.x+".\n(*) y: "+this.y+".";
    }
}

