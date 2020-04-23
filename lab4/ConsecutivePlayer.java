import java.util.Scanner;

public class ConsecutivePlayer extends Player {

    private int lastIdx;

    public ConsecutivePlayer(String name) {
        super(name);
        this.lastIdx = 0;

    }

    public Action selectAction(Action[] actions) {
        this.lastIdx+=1;
        Scanner userInput = new Scanner(System.in);
        if (actions[0].getName().equals("talk")) {
            int k1;
            do {
                System.out.println(" choose an action:\n(*) talk - press 1.(*) shut up - press 2. ");
                k1 = userInput.nextInt();
            } while (k1 != 1 && k1 != 2);

            if (k1 == 1) {
                return actions[0];
            } else {
                return actions[1];
            }
        }
        else{
            int k1;
            do {
                System.out.println(" choose an action:\n(*) Rock - press 1.\n(*) Pepper - press 2.\n(*) Scissors - press 3. ");
                k1 = userInput.nextInt();
            } while (k1 != 1 && k1 != 2 && k1 !=3);

            if (k1 == 1) {
                return actions[0];
            } else if(k1 == 2) {
                return actions[1];
            }
            else {
                return actions[2];
            }
        }

    }
}
