package Java;

import java.util.*;

public class SpellChecker2 {
  public static String findClosestWord(String misspelledWord, Set<String> dictionary) {
    int minDistance = Integer.MAX_VALUE;
    String closestWord = "";

    for (String word : dictionary) {
      int distance = calculateEditDistance(misspelledWord, word);
      if (distance < minDistance) {
        minDistance = distance;
        closestWord = word;
      }
    }

    return closestWord;
  }

  public static int calculateEditDistance(String word1, String word2) {
    int[][] dp = new int[word1.length() + 1][word2.length() + 1];

    for (int i = 0; i <= word1.length(); i++) {
      dp[i][0] = i;
    }

    for (int j = 0; j <= word2.length(); j++) {
      dp[0][j] = j;
    }

    for (int i = 1; i <= word1.length(); i++) {
      for (int j = 1; j <= word2.length(); j++) {
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          int replaceCost = dp[i - 1][j - 1] + 1;
          int insertCost = dp[i][j - 1] + 1;
          int deleteCost = dp[i - 1][j] + 1;
          dp[i][j] = Math.min(replaceCost, Math.min(insertCost, deleteCost));
        }
      }
    }

    return dp[word1.length()][word2.length()];
  }

  public static void main(String[] args) {
    Set<String> dictionary = new HashSet<>();
    dictionary.add("apple");
    dictionary.add("banana");
    dictionary.add("orange");
    dictionary.add("pear");

    String misspelledWord = "aple";
    String closestWord = findClosestWord(misspelledWord, dictionary);

    System.out.println("Misspelled Word: " + misspelledWord);
    System.out.println("Closest Correct Word: " + closestWord);
  }
}