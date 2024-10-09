package Java;

import java.util.ArrayList;

public class ArrayListAddEfficiency {

  public static void main(String[] args) {
    // Initialize ArrayList
    ArrayList<Integer> list = new ArrayList<>();

    // Define the range of n values
    int[] nValues = { 1000, 5000, 10000, 50000 };

    // Scenario: Each add takes place at index 0
    System.out.println("Scenario: Add at index 0");
    for (int n : nValues) {
      long startTime = System.nanoTime();
      for (int i = 0; i < n; i++) {
        list.add(0, i);
      }
      long endTime = System.nanoTime();
      long duration = endTime - startTime;
      System.out.println("n = " + n + ", Time taken: " + duration + " nanoseconds");
      list.clear();
    }

    // Scenario: Each add takes place at index size()/2
    System.out.println("Scenario: Add at index size()/2");
    for (int n : nValues) {
      long startTime = System.nanoTime();
      for (int i = 0; i < n; i++) {
        list.add(list.size() / 2, i);
      }
      long endTime = System.nanoTime();
      long duration = endTime - startTime;
      System.out.println("n = " + n + ", Time taken: " + duration + " nanoseconds");
      list.clear();
    }

    // Scenario: Each add takes place at index size()
    System.out.println("Scenario: Add at index size()");
    for (int n : nValues) {
      long startTime = System.nanoTime();
      for (int i = 0; i < n; i++) {
        list.add(i);
      }
      long endTime = System.nanoTime();
      long duration = endTime - startTime;
      System.out.println("n = " + n + ", Time taken: " + duration + " nanoseconds");
      list.clear();
    }
  }
}