package Java;

public class RabinKarp {
  public static final int d = 256; // Number of characters in the input alphabet
  public static final int prime = 101; // A prime number

  public static void search(String pattern, String text) {
    int m = pattern.length();
    int n = text.length();
    int patternHash = 0; // Hash value for pattern
    int textHash = 0; // Hash value for current text window

    // Calculate the hash value of pattern and the first window of text
    for (int i = 0; i < m; i++) {
      patternHash = (d * patternHash + pattern.charAt(i)) % prime;
      textHash = (d * textHash + text.charAt(i)) % prime;
    }

    for (int i = 0; i <= n - m; i++) {
      // Check if the hash values match
      if (patternHash == textHash) {
        int j;
        for (j = 0; j < m; j++) {
          if (text.charAt(i + j) != pattern.charAt(j)) {
            break;
          }
        }
        if (j == m) {
          System.out.println("Pattern found at index " + i);
        }
      }

      // Calculate hash value for next window of text
      if (i < n - m) {
        textHash = (d * (textHash - text.charAt(i) * (int) Math.pow(d, m - 1)) + text.charAt(i + m)) % prime;
        if (textHash < 0) {
          textHash += prime; // Ensure positive value
        }
      }
    }
  }

  public static void main(String[] args) {
    String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.";
    String pattern = "ipsum";

    search(pattern, text);
  }
}