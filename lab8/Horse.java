public class Horse implements Runnable{
    private String name;
    private float distance;
    private FinishingLine arrive;

    Horse(String id, FinishingLine f, int distance){
        this.name = id;
        this.distance = distance;
        arrive = f;

    }

    public void run()
    {
        while (distance > 0) {
            System.out.println(name + " is " + distance + " from the finishing line.");

            try {
                Thread.sleep(1000);
                distance -= 2.5;
            } catch (InterruptedException e) {
                System.out.println("interruption has been made");
            }
        }


        arrive.Arrive(name);
        //arrive.addToTable(name);



    }

    public String getId()
    {
        return this.name;
    }

}

class FinishingLine{

    private String[] winnersTable;
    private int i;
    private boolean arrive;
    private boolean flag;

    FinishingLine()
    {
        winnersTable = new String[10];
        i = 0;
        arrive = false;
        flag = false;

    }
    public void Arrive(String name){
        System.out.println(name + " is Arrived to the finishing line");
        System.out.println(" ");
    }

    public void addToTable(String name){
        winnersTable[i] = name;
        ++i;
    }

    public String[] getTable()
    {
        return winnersTable;
    }

    public Boolean getArrive(){
        return arrive;
    }

    public Boolean getFlag(){
        return flag;
    }
    public void setFlag(boolean bol){
        flag = bol;
    }


}

class HorsesRace{


    public static void main(String[] args) {

        Horse[] myHorses = new Horse[10];
        FinishingLine finish = new FinishingLine();

        myHorses[0] = new Horse("Jack", finish, 10);
        myHorses[1] = new Horse("Jim", finish, 10);
        myHorses[2] = new Horse("Rock", finish, 10);
        myHorses[3] = new Horse("Splash", finish, 10);
        myHorses[4] = new Horse("Smack", finish, 10);
        myHorses[5] = new Horse("Ara-Ara", finish, 10);
        myHorses[6] = new Horse("suibitzu", finish, 10);
        myHorses[7] = new Horse("papaya-watermelon", finish, 10);
        myHorses[8] = new Horse("foo", finish, 10);
        myHorses[9] = new Horse("ash-katchem", finish, 10);

        Thread[] horse = new Thread[10];

        for (int i = 0; i< myHorses.length; ++i){
            horse[i] = new Thread(myHorses[i]);
        }
        for (int i = 0; i< myHorses.length; ++i){
            horse[i].start();
        }

        //System.out.println("THE WINNER IS: ***" + finish.getTable()[0]+ "***");


    }
}