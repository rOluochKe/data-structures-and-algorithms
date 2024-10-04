package Java;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CharacterFrequencyCounter {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter the document:");
    String document = scanner.nextLine();

    Map<Character, Integer> frequencyMap = new HashMap<>();

    for (char c : document.toCharArray()) {
      if (Character.isLetter(c)) {
        char lowercaseC = Character.toLowerCase(c);
        frequencyMap.put(lowercaseC, frequencyMap.getOrDefault(lowercaseC, 0) + 1);
      }
    }

    for (char c = 'a'; c <= 'z'; c++) {
      int frequency = frequencyMap.getOrDefault(c, 0);
      System.out.print(c + ": ");
      for (int i = 0; i < frequency; i++) {
        System.out.print("|");
      }
      System.out.println();
    }

    scanner.close();
  }
}