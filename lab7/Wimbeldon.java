import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Wimbeldon {
    public static Player simulateTournament(QueueAsList playersList)
    {
        Player a;
        Player b;
        while(playersList.getSize() > 1)
        {
            a = (Player)playersList.dequeue();
            b = (Player)playersList.dequeue();


            playersList.enqueue(simulateGame(a,b));
        }
        return playersList.getWinner();
    }

    public static Player simulateGame(Player first, Player second)
    {
        Random rand = new Random();
        int key = rand.nextInt(2);
        if (key == 0){
            return first;
        }
        else {
            return second;
        }

    }


    public static void main(String[] args)
    {
        //need to receive players:
        int j = 0;
        QueueAsList myQueue = new QueueAsList();
        String[] playerNames  = ReadFile();
        Player winner;
        assert playerNames != null;

        // checking file inputs

        System.out.println(Arrays.toString(playerNames));

        Player[] myPlayers = new Player[playerNames.length];

        for(int i = 0; i< playerNames.length;++i) {
            myPlayers[i] = new Player(playerNames[i]);
        }

        while (j<playerNames.length)
        {
            myQueue.enqueue(myPlayers[j]);
            ++j;
        }
        winner = simulateTournament(myQueue);
        System.out.println("The winner is: " + winner.getName());











    }
    private static File loadFileFunc() {
        //Instead of "new Frame()" use a real frame
        FileDialog fd = new FileDialog(new Frame(), "Please choose a file:", FileDialog.LOAD);

        fd.setVisible(true);
        File f;
        if (fd.getFile() != null) {

            f = new File(fd.getDirectory(), fd.getFile());
            System.out.println(f.getPath());
            return f;
        }

        return null;
    }

    public static String[] ReadFile() {
        int count= 0, i=0;
        try {
            File myObj = loadFileFunc();

            assert myObj != null;
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                count += 1;
                myReader.nextLine();
            }
            myReader.close();

            String[] names = new String[count];

            myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                names[i] = myReader.nextLine();
                i +=1;
            }
            myReader.close();
            return names;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }
    }

}
