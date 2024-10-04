package Java;

import java.util.Random;
import java.util.HashSet;

public class BirthdayParadox {
  public static void main(String[] args) {
    Random random = new Random();

    for (int n = 5; n <= 100; n += 5) {
      int successCount = 0;
      int experiments = 10000;

      for (int i = 0; i < experiments; i++) {
        if (hasSameBirthday(n, random)) {
          successCount++;
        }
      }

      double probability = (double) successCount / experiments;
      System.out.println("For n = " + n + ", Probability: " + probability);
    }
  }

  private static boolean hasSameBirthday(int n, Random random) {
    HashSet<Integer> birthdays = new HashSet<>();

    for (int i = 0; i < n; i++) {
      int birthday = random.nextInt(365); // 365 possible birthdays
      if (birthdays.contains(birthday)) {
        return true;
      }
      birthdays.add(birthday);
    }

    return false;
  }
}