// Brute-Force Pattern Matching Algorithm
public class BruteForce {
  public static int bruteForce(String text, String pattern) {
    int textLength = text.length();
    int patternLength = pattern.length();

    for (int i = 0; i <= textLength - patternLength; i++) {
      int j;
      for (j = 0; j < patternLength; j++) {
        if (text.charAt(i + j) != pattern.charAt(j)) {
          break;
        }
      }
      if (j == patternLength) {
        return i; // pattern found at index i in the text
      }
    }
    return -1; // pattern not found in the text
  }
}

// Knuth-Morris-Pratt (KMP) Pattern Matching Algorithm
public class KMP {
  public static int[] computeLPSArray(String pattern) {
    // Implementation of computeLPSArray method
  }

  public static int kmpSearch(String text, String pattern) {
    // Implementation of kmpSearch method
  }
}

// Boyer-Moore Pattern Matching Algorithm
public class BoyerMoore {
  public static int boyerMoore(String text, String pattern) {
    // Implementation of Boyer-Moore pattern matching algorithm
  }
}