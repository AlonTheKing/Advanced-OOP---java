public class RandomPlayer extends Player{

    public RandomPlayer(String name) {
        super(name);
    }

    public Action selectAction(Action[] actions){
        return actions[(int)(Math.random()*actions.length)];
    }
}
