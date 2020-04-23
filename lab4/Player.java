public abstract class Player {
    private String name;
    private int score;

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public abstract Action selectAction(Action[] actions);

    public boolean isWinner(Player p) {
        if (this.score > p.score)
            return true;
        else if (this.score == p.score) {
            System.out.println("it's a draw!");
        } else {
            return false;
        }
        return false;
    }


    public void updateScore(int score) {
        this.score += score;

    }

    public int getScore() {
        return this.score;
    }

    public String getName() {
        return this.name;
    }
}
