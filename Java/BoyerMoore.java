package Java;

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

// Boyer-Moore Pattern Matching Algorithm
public class BoyerMoore {
  public static int boyerMoore(String text, String pattern) {
    int[] badMatchTable = new int[256];
    int textLength = text.length();
    int patternLength = pattern.length();

    // Preprocess the pattern
    int[] occurrence = new int[256];
    for (int i = 0; i < 256; i++) {
      occurrence[i] = -1;
    }
    for (int i = 0; i < patternLength; i++) {
      occurrence[pattern.charAt(i)] = i;
    }

    int i = patternLength - 1;
    int j = patternLength - 1;
    while (i < textLength) {
      if (text.charAt(i) == pattern.charAt(j)) {
        if (j == 0) {
          return i; // pattern found at index i in the text
        }
        i--;
        j--;
      } else {
        i += patternLength - Math.min(j, 1 + occurrence[text.charAt(i)]);
        j = patternLength - 1;
      }
    }
    return -1; // pattern not found in the text
  }
}