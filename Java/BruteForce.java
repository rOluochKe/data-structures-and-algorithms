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

// Knuth-Morris-Pratt (KMP) Pattern Matching Algorithm
public class KMP {
  public static int[] computeLPSArray(String pattern) {
    int patternLength = pattern.length();
    int[] lps = new int[patternLength];
    int len = 0;
    int i = 1;
    lps[0] = 0;

    while (i < patternLength) {
      if (pattern.charAt(i) == pattern.charAt(len)) {
        len++;
        lps[i] = len;
        i++;
      } else {
        if (len != 0) {
          len = lps[len - 1];
        } else {
          lps[i] = 0;
          i++;
        }
      }
    }
    return lps;
  }

  public static int kmpSearch(String text, String pattern) {
    int textLength = text.length();
    int patternLength = pattern.length();
    int[] lps = computeLPSArray(pattern);

    int i = 0;
    int j = 0;

    while (i < textLength) {
      if (pattern.charAt(j) == text.charAt(i)) {
        i++;
        j++;
      }
      if (j == patternLength) {
        return i - j; // pattern found at index i-j in the text
      } else if (i < textLength && pattern.charAt(j) != text.charAt(i)) {
        if (j != 0) {
          j = lps[j - 1];
        } else {
          i++;
        }
      }
    }
    return -1; // pattern not found in the text
  }
}