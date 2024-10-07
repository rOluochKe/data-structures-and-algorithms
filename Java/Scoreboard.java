package Java;

// Class to represent a game entry
public class GameEntry {
  private String name;
  private int score;

  // Constructor
  public GameEntry(String n, int s) {
    name = n;
    score = s;
  }

  // Get the player's name
  public String getName() {
    return name;
  }

  // Get the player's score
  public int getScore() {
    return score;
  }

  // String representation of the GameEntry
  public String toString() {
    return "(" + name + " " + score + ")";
  }
}

// Class to represent a scoreboard
public class Scoreboard {
  private int numEntries = 0;
  private GameEntry[] board;

  // Constructor that sets the capacity of the scoreboard
  public Scoreboard(int capacity) {
    board = new GameEntry[capacity];
  }

  // Method to add a GameEntry to the scoreboard
  public void add(GameEntry e) {
    int newScore = e.getScore();

    // Check if the new score should be added
    if (numEntries < board.length || newScore > board[numEntries - 1].getScore()) {
      if (numEntries < board.length)
        numEntries++;

      int j = numEntries - 1;
      // Shift lower scores down the board
      while (j > 0 && board[j - 1].getScore() < newScore) {
        board[j] = board[j - 1];
        j--;
      }
      board[j] = e;  // Place new entry
    }
  }

  // Method to remove a GameEntry from the scoreboard
  public GameEntry remove(int i) throws IndexOutOfBoundsException {
    if (i < 0 || i >= numEntries)
      throw new IndexOutOfBoundsException("Invalid index: " + i);

    GameEntry temp = board[i];
    // Shift entries down
    for (int j = i; j < numEntries - 1; j++)
      board[j] = board[j + 1];
    board[numEntries - 1] = null;
    numEntries--;
    return temp;
  }
}

// Method to perform insertion sort on an array of characters
public static void insertionSort(char[] data) {
  int n = data.length;
  for (int k = 1; k < n; k++) {
    char cur = data[k];
    int j = k;
    // Shift larger values to the right
    while (j > 0 && data[j - 1] > cur) {
      data[j] = data[j - 1];
      j--;
    }
    data[j] = cur;
  }
}

// Class for testing arrays and sorting
import java.util.Arrays;
import java.util.Random;

public class ArrayTest {
  public static void main(String[] args) {
    int data[] = new int[10];
    Random rand = new Random();
    rand.setSeed(System.currentTimeMillis());

    // Fill the array with random values
    for (int i = 0; i < data.length; i++)
      data[i] = rand.nextInt(100);

    // Copy the original array
    int[] orig = Arrays.copyOf(data, data.length);

    // Test before sorting
    System.out.println("arrays equal before sort: " + Arrays.equals(data, orig));

    // Sort the array
    Arrays.sort(data);

    // Test after sorting
    System.out.println("arrays equal after sort: " + Arrays.equals(data, orig));
    System.out.println("orig = " + Arrays.toString(orig));
    System.out.println("data = " + Arrays.toString(data));
  }
}
