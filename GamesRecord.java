import java.util.Collections;
import java.util.ArrayList;

public class GamesRecord {

    ArrayList<Game> gamesRecord;

    public GamesRecord() {
        this.gamesRecord = new ArrayList<>();
    }

    public void add(Game game) {
        gamesRecord.add(game);
    }

    public int average() {
        int i = 0;
        int runningTotal = 0;

        while (i < gamesRecord.size()) {
            Game oneGame = gamesRecord.get(i);
            runningTotal = runningTotal + oneGame.getScore();
            i++;
        }

        return runningTotal / gamesRecord.size();
    }

    public int average(String playerID) {
        int i = 0;
        int runningTotal = 0;
        int howMany = 0;

        while (i < gamesRecord.size()) {
            Game oneGame = gamesRecord.get(i);
            String thisID = oneGame.getPlayerID();
            if (playerID == thisID) {
                howMany++;
                runningTotal = runningTotal + oneGame.getScore();
            }
        }
        return runningTotal / howMany;
    }

    public ArrayList<Game> highGameList(int n) {
        ArrayList<Game> topList = new ArrayList<>();
        Collections.sort(gamesRecord);

        int i = 0;
        while (i < n) {
            Game oneGame = gamesRecord.get(i);
            topList.add(oneGame);
        }
        return topList;
    }

    public String toString() {
        int i = 0;
        int size = gamesRecord.size();
        StringBuilder builder = new StringBuilder();
        while(i < size) {
            Game thisGame = gamesRecord.get(i);
            String thisID = thisGame.getPlayerID();
            int thisScore = thisGame.getScore();
            builder.append(thisID);
            builder.append(": ");
            builder.append(Integer.toString(thisScore));
            builder.append("\n");
            i++;
        }
        return builder.toString();
    }
}
