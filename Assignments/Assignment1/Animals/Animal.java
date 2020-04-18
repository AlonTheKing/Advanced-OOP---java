/*
package used - Animals
 */
package Animals;

/*
relevant imports: Mobility.Mobile, Mobility.Point, Olympics.Medal
 */

import Mobility.Mobile;
import Mobility.Point;
import Olympics.Medal;

/*
this class is an abstract class which is representing all animals
it's a derived class of Mobile.
 */
public abstract class Animal extends Mobile {
    protected Gender myGender;
    protected String name;
    protected Double weight;
    protected Double speed;
    protected Medal[] medal;
    protected Point position;

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
    this function will make the required animal sound
     */
        public Boolean makeSound () {
            if (this instanceof Dog) {
                System.out.println("Animal " + this.name + " said Woof Woof.");
                return true;
            }
            if (this instanceof Cat) {
                System.out.println("Animal " + this.name + " said Meow.");
                return true;

            }
            if (this instanceof Snake) {
                System.out.println("Animal " + this.name + " said ssssssss.");
                return true;

            }
            if (this instanceof Alligator) {
                System.out.println("Animal " + this.name + " said Roar.");
                return true;

            }
            if (this instanceof Whale) {
                System.out.println("Animal " + this.name + " said Splash.");
                return true;

            }
            if (this instanceof Dolphin) {
                System.out.println("Animal " + this.name + " said Click-click.");
                return true;

            }
            if (this instanceof Eagle) {
                System.out.println("Animal " + this.name + " said Clack-wack-chack.");
                return true;

            }
            if (this instanceof Pigeon) {
                System.out.println("Animal " + this.name + " said Arr-rar-rar-rar-raah.");
                return true;

            }
            return false;
        }


    }
