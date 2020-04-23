public abstract class Game {

    private Player p1, p2;
    private String name;     //game name
    protected Action[] actions; // the set of actions

    public Game(Player p1, Player p2, String name) {
        // initializing the players
        this.p1 = p1;
        this.p2 = p2;

        //initializing the name of the game
        this.name = new String(name);


    }

    protected abstract void initActions();

    public void play(int turnCount) {
        for (int i = 0; i < turnCount; ++i) {
            playSingleTurn();
        }
    }

    private void playSingleTurn() {
        rewardPlayers(p1.selectAction(actions), p2.selectAction(actions));
    }

    protected abstract void rewardPlayers(Action a1, Action a2);

    public Player getWinner() {
        if (this.p1.isWinner(this.p2)) {
            return this.p1;
        }
        else {
            return this.p2;
        }
    }

    public Player getLoser () {
        if(p1.isWinner(p2))
            return p2;
        return p1;
    }

    protected Player getFirstPlayer() {
        return this.p1;
    }

    protected Player getSecondPlayer() {

        return this.p2;
    }

    public String getName(){

        return this.name;
    }

}

