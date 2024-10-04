package Java;

import java.util.Random;

public class SentenceWriter {
  public static void main(String[] args) {
    String sentence = "I will never spam my friends again.";
    int numSentences = 100;
    Random random = new Random();

    for (int i = 1; i <= numSentences; i++) {
      StringBuilder sb = new StringBuilder();
      sb.append(i).append(". ");

      // Introduce 8 random-looking typos
      for (char c : sentence.toCharArray()) {
        if (random.nextInt(10) == 0) {
          // Generate random typo
          char typo = (char) ('a' + random.nextInt(26));
          sb.append(typo);
        } else {
          sb.append(c);
        }
      }

      System.out.println(sb.toString());
    }
  }
}