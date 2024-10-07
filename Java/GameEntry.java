package Java;

public class GameEntry {
  private String name;
  private int score;

  public GameEntry(String n, int s) {
    name = n;
    score = s;
  }

  public String getName() {
    return name;
  }

  public int getScore() {
    return score;
  }

  public String toString() {
    return "(" + name + " " + score + ")";
  }
}

public class Scoreboard {
  private int numEntries = 0;
  private GameEntry[] board;

  public Scoreboard(int capacity) {
    board = new GameEntry[capacity];
  }

  public void add(GameEntry e) {
    int newScore = e.getScore();

    if (numEntries < board.length || newScore > board[numEntries - 1].getScore()) {
      if (numEntries < board.length)
        numEntries++;

      int j = numEntries - 1;
      while (j > 0 && board[j - 1].getScore() < newScore) {
        board[j] = board[j - 1];
        j--;
      }
      board[j] = e;
    }
  }
}