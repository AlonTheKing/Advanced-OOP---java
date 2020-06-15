/*
package used - Animals
 */
package Animals;

/*
relevant imports: Mobility.Mobile, Mobility.Point, Olympics.Medal, graphics.IAnimal, graphics.IClonable, Mobility.ILocatable, graphics.IDrawable
 */

import Mobility.ILocatable;
import Mobility.Mobile;
import Mobility.Point;
import Olympics.Medal;
import graphics.IAnimal;
import graphics.IClonable;
import graphics.IDrawable;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

/*
this class is an abstract class which is representing all animals
it's a derived class of Mobile.
 */
public abstract class Animal extends Mobile implements IAnimal, IClonable, ILocatable, IDrawable {
    protected Gender myGender;
    protected String name;
    protected Double weight;
    protected Double speed;
    protected Medal[] medal;
    protected Point position;

    // new fields.

    protected int size;
    protected Orientation orien;
    protected int maxEnergy = 500;
    protected int energyPerMeter;
    protected int addEdnergy;
    protected int currEnergy;
    /*
    i constructed my design so i wouldn't need to use CompetitionPanel pan/
     */
    //protected CompetitionPanel pan;
    protected BufferedImage img1, img2, img3, img4;
    private String skin;

    /*
    (*) this is the Animal constructor (*)

    @param: name gives the name of the animal
    @param: valGender gives the Gender of the animal
    @param: weight gives the weight of the animal
    @param: speed gives the speed of the animal
    @param: medal gives an array of references to Medal
    @param: position gives the position of the animal
     */

    Animal(String name, Gender valGender, double weight, double speed, Medal[] medal, Point position, String animalCategory, String skin, int energy, int energyPerMeter) throws IOException {
        super(position);

        this.addEdnergy = this.currEnergy = energy;
        this.energyPerMeter = energyPerMeter;

        this.position = new Point(position.x, position.y);
        setBaseStuff(name, valGender, weight, speed, medal);
        //setAdvancedStuff();
        this.skin = skin;
        setImages(animalCategory, skin);
        orien = Orientation.EAST;
    }

    /*
    setImages is a method that can upload the needed images based on the animal type
    @param: String animalCategory
    @param: String skin
     */
    private void setImages(String animalCategory, String skin) throws IOException {
        String path;

        if (animalCategory.equals("Terrestrial Animal") && !this.getClass().getSimpleName().equals("Alligator")) {
            path = "C:\\Users\\david\\IdeaProjects\\assignment2 gui\\src\\graphicsAnimals\\" + skin + "E.png";
            img1 = ImageIO.read(new File(path));

            path = "C:\\Users\\david\\IdeaProjects\\assignment2 gui\\src\\graphicsAnimals\\" + skin + "S.png";
            img2 = ImageIO.read(new File(path));

            path = "C:\\Users\\david\\IdeaProjects\\assignment2 gui\\src\\graphicsAnimals\\" + skin + "W.png";
            img3 = ImageIO.read(new File(path));

            path = "C:\\Users\\david\\IdeaProjects\\assignment2 gui\\src\\graphicsAnimals\\" + skin + "N.png";
            img4 = ImageIO.read(new File(path));
        } else if (animalCategory.equals("Terrestrial Animal") && this.getClass().getSimpleName().equals("Alligator")) {
            path = "C:\\Users\\david\\IdeaProjects\\assignment2 gui\\src\\graphicsAnimals\\" + skin + "E.png";
            img1 = ImageIO.read(new File(path));

            path = "C:\\Users\\david\\IdeaProjects\\assignment2 gui\\src\\graphicsAnimals\\" + skin + "W.png";
            img2 = ImageIO.read(new File(path));

        } else if (animalCategory.equals("Water Animal") && this.getClass().getSimpleName().equals("Alligator")) {
            path = "C:\\Users\\david\\IdeaProjects\\assignment2 gui\\src\\graphicsAnimals\\" + skin + "E.png";
            img1 = ImageIO.read(new File(path));

            path = "C:\\Users\\david\\IdeaProjects\\assignment2 gui\\src\\graphicsAnimals\\" + skin + "W.png";
            img2 = ImageIO.read(new File(path));
        } else if (animalCategory.equals("Water Animal") && !this.getClass().getSimpleName().equals("Alligator")) {
            path = "C:\\Users\\david\\IdeaProjects\\assignment2 gui\\src\\graphicsAnimals\\" + skin + "E.png";
            img1 = ImageIO.read(new File(path));

            path = "C:\\Users\\david\\IdeaProjects\\assignment2 gui\\src\\graphicsAnimals\\" + skin + "W.png";
            img2 = ImageIO.read(new File(path));
        } else {
            path = "C:\\Users\\david\\IdeaProjects\\assignment2 gui\\src\\graphicsAnimals\\" + skin + "E.png";
            img1 = ImageIO.read(new File(path));
        }

    }

    /*
    setBaseStuff is method that initialize the field from work1
    @param: name gives the name of the animal
    @param: valGender gives the Gender of the animal
    @param: weight gives the weight of the animal
    @param: speed gives the speed of the animal
    @param: medal gives an array of references to Medal
     */
    private void setBaseStuff(String name, Gender valGender, double weight, double speed, Medal[] medal) {
        // checking if the type is right
        if (name != null) {
            if (((Object) name).getClass().getName().equals("java.lang.String")) {
                this.name = name;
            }
        }
        this.myGender = valGender;
        // checking if the type is right

        if (((Object) weight).getClass().getName().equals("java.lang.Double") && weight > 0.0) {
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
        this.totalDistance =  Math.sqrt(Math.pow(other.x, 2) + Math.pow(other.y, 2));
        return totalDistance;
    }


    /*
    this function will make the required animal sound
     */
    abstract public Boolean makeSound();

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

    // additional getters:

    abstract public String getType();

    public Gender getMyGender() {
        return myGender;
    }

    public String getName() {
        return name;
    }

    public Double getWeight() {
        return weight;
    }

    public Double getSpeed() {
        return speed;
    }

    public Medal[] getMedal() {
        return medal;
    }

    public Point getPosition() {
        return position;
    }

    public Orientation getOrien() {
        return orien;
    }

    public int getMaxEnergy() {
        return maxEnergy;
    }

    public int getEnergyPerMeter() {
        return energyPerMeter;
    }

    public BufferedImage getImg1() {
        return img1;
    }

    public BufferedImage getImg2() {
        return img2;
    }

    public BufferedImage getImg3() {
        return img3;
    }

    public BufferedImage getImg4() {
        return img4;
    }

    public String getSkin() {
        return skin;
    }

    abstract public void setEnergyPerMeter(int x);

    public void AddEnergy(int x) {
        {
            if (this.maxEnergy > this.currEnergy + x) {
                this.addEdnergy += x;
                this.currEnergy += x;
            } else {
                throw new RuntimeException("above max energy");
            }
        }
    }
    public int GetAddedEnergy(){
        return this.addEdnergy;
    }
    public void Eat(){
        this.currEnergy -= this.energyPerMeter;
    }


    abstract public int getCurrEnergy();

}

