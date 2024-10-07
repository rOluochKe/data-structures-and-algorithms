package Java;

import java.util.Arrays;
import java.util.Random;

public class ArraySortAnalysis {

  public static void main(String[] args) {
    Random random = new Random();
    int[] inputSizes = { 1000, 5000, 10000, 50000, 100000 };
    long[] times = new long[inputSizes.length];

    for (int i = 0; i < inputSizes.length; i++) {
      int[] arr = new int[inputSizes[i]];
      for (int j = 0; j < inputSizes[i]; j++) {
        arr[j] = random.nextInt();
      }

      long startTime = System.nanoTime();
      Arrays.sort(arr);
      long endTime = System.nanoTime();
      times[i] = endTime - startTime;
    }

    // Perform analysis to test the hypothesis that Arrays.sort runs in O(n log n)
    // time
    // You can visualize the results and analyze the time complexity
  }
}