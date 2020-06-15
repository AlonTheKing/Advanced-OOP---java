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
this class represent a Snake, which is derived from TerrestrialAnimals and implement IReptile interface
 */
public class Snake extends TerrestrialAnimals implements IReptile {
    public enum Poisonous {
        High, Medium, Low
    }

    protected Poisonous poison;
    protected Boolean isPoison;
    protected double length;

    /*
       (*) this is the Snake constructor (*)

       @param: noLegs gives the number of legs of the animal
       @param: name gives the name of the animal
       @param: valGender gives the Gender of the animal
       @param: weight gives the weight of the animal
       @param: speed gives the speed of the animal
       @param: medal gives an array of references to Medal
       @param: position gives the position of the animal
       @param: poison gives us the enum value that represent if the snake is poisonous or not.
       @param: length gives us the length of the snake

   */
    public Snake(Poisonous poison, double length, int noLegs, String name, Gender valGender, double weight, double speed, Medal[] medal, Point position, String animalCategory, String skin,int energy, int energyPerMeter) throws IOException {
        super(noLegs, name, valGender, weight, speed, medal, position,animalCategory,skin,energy,energyPerMeter);
        if (length > 0) {
            this.length = length;
        }

        this.poison = poison;
    }

    /*
   this function will speed the reptile's movement
   @param: speedToAdd gives us the additional speed
   @return the new speed
    */
    @Override
    public double speedUp(int speedToAdd) {
        if (this.speed + speedToAdd > MAX_SPEED){
            System.out.println("alligator cannot be fasted than 5 km/h.");
        }
        else{
            this.speed +=speedToAdd;
        }
        return this.speed;
    }


    public Boolean makeSound () {
        System.out.println("Animal " + this.name + " said ssssssss.");
        return true;
    }

    /*
   this function will give us all the information regard the animal
   @return: a String of the animal's information
    */
    public String toString() {
        return "*** SNAKE'S INFORMATION ***:\n" + super.toString() +  "(*) Number of legs: " + this.noLegs + "." +
                "\n(*) Length: " + this.length + ".\n(*) Poisonous: "+this.poison+".\n\n";
    }

}
