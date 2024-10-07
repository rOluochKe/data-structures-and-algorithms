package Java;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DuckDuckGooseGame {
  private List<String> children;
  private int itIndex;

  public DuckDuckGooseGame(List<String> children) {
    this.children = new ArrayList<>(children);
    this.itIndex = 0;
  }

  public void playRound() {
    int gooseIndex = new Random().nextInt(children.size());

    System.out.println("It starts patting heads around the circle...");
    for (int i = 0; i < children.size(); i++) {
      System.out.println("Duck");
      if (i == gooseIndex) {
        System.out.println("Goose!");
        break;
      }
    }

    raceAroundCircle(gooseIndex);
  }

  private void raceAroundCircle(int gooseIndex) {
    int gooseIndexFromStart = (gooseIndex + itIndex) % children.size();
    System.out
        .println(children.get(itIndex) + " and " + children.get(gooseIndexFromStart) + " race around the circle!");

    if (gooseIndexFromStart < itIndex) {
      System.out.println(children.get(itIndex) + " wins and remains in the circle.");
    } else {
      System.out.println(children.get(gooseIndexFromStart) + " wins and becomes the new 'it'.");
      itIndex = (gooseIndexFromStart + 1) % children.size();
    }
  }

  public static void main(String[] args) {
    List<String> children = new ArrayList<>();
    children.add("Alice");
    children.add("Bob");
    children.add("Charlie");
    children.add("David");

    DuckDuckGooseGame game = new DuckDuckGooseGame(children);
    game.playRound();
  }
}