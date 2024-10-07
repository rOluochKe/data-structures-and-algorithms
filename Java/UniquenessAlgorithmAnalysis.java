package Java;

import java.util.Random;

public class UniquenessAlgorithmAnalysis {

  public static void unique1(int[] data) {
    // Algorithm unique1 implementation
  }

  public static void unique2(int[] data) {
    // Algorithm unique2 implementation
  }

  public static void main(String[] args) {
    Random random = new Random();
    int n = 1;
    long startTime, endTime, duration;

    // Determine the largest value of n that runs in one minute or less for unique1
    do {
      int[] data = new int[n];
      for (int i = 0; i < n; i++) {
        data[i] = random.nextInt();
      }

      startTime = System.currentTimeMillis();
      unique1(data);
      endTime = System.currentTimeMillis();
      duration = endTime - startTime;

      n *= 2;
    } while (duration < 60000);

    System.out.println("Largest n for unique1 within one minute: " + n / 2);

    // Determine the largest value of n that runs in one minute or less for unique2
    n = 1;
    do {
      int[] data = new int[n];
      for (int i = 0; i < n; i++) {
        data[i] = random.nextInt();
      }

      startTime = System.currentTimeMillis();
      unique2(data);
      endTime = System.currentTimeMillis();
      duration = endTime - startTime;

      n *= 2;
    } while (duration < 60000);

    System.out.println("Largest n for unique2 within one minute: " + n / 2);
  }
}