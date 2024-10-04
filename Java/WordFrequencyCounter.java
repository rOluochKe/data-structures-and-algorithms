package Java;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordFrequencyCounter {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter a list of words separated by whitespace:");
    String input = scanner.nextLine();

    String[] words = input.split("\\s+");

    Map<String, Integer> wordFrequency = new HashMap<>();

    for (String word : words) {
      if (wordFrequency.containsKey(word)) {
        wordFrequency.put(word, wordFrequency.get(word) + 1);
      } else {
        wordFrequency.put(word, 1);
      }
    }

    System.out.println("Word Frequency:");
    for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
      System.out.println(entry.getKey() + ": " + entry.getValue());
    }
  }
}