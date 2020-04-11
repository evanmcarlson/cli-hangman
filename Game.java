public abstract class Game implements Comparable {
    public int score;
    public String id;

    public Game(String id) {
        this.score = 0;
        this.id = id;
    }

    public int getScore() {
        return this.score;
    }

    public String getPlayerID() {
        return this.id;
    }

    public int compareTo(Object other) {
        Game otherGame = (Game) other;

        //high scores are typically better
        if (this.score < otherGame.score) {
            return -1;
        } else {
            if (this.score == otherGame.score) {
                return 0;
            } else {
                return 1;
            }
        }
    }
}