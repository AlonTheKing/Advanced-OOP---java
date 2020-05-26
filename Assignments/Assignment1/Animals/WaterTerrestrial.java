package Animals;

public class WaterTerrestrial  implements  IWater, ITerrestrial{
    private int numberOfLegs;
    private double depth;

    @Override
    public void setNumberOfLegs(int x) {
        this.numberOfLegs = x;
    }

    @Override
    public int getNumberOfLegs() {
        return this.numberOfLegs;
    }

    @Override
    public void setDepth(double x) {
        this.depth = x;
    }

    @Override
    public double getDepth() {
        return this.depth;
    }

}
