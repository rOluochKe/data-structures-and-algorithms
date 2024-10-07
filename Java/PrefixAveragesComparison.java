package Java;

import java.util.Arrays;

public class PrefixAveragesComparison {

  public static double[] prefixAverage1(int[] X) {
    int n = X.length;
    double[] A = new double[n];

    for (int i = 0; i < n; i++) {
      int sum = 0;
      for (int j = 0; j <= i; j++) {
        sum += X[j];
      }
      A[i] = (double) sum / (i + 1);
    }

    return A;
  }

  public static double[] prefixAverage2(int[] X) {
    int n = X.length;
    double[] A = new double[n];
    int sum = 0;

    for (int i = 0; i < n; i++) {
      sum += X[i];
      A[i] = (double) sum / (i + 1);
    }

    return A;
  }

  public static void main(String[] args) {
    int[] inputSizes = { 10, 100, 1000, 10000, 100000 };
    long[] times1 = new long[inputSizes.length];
    long[] times2 = new long[inputSizes.length];

    for (int i = 0; i < inputSizes.length; i++) {
      int[] X = new int[inputSizes[i]];
      Arrays.fill(X, 1); // Filling with 1 for simplicity

      long startTime1 = System.nanoTime();
      prefixAverage1(X);
      long endTime1 = System.nanoTime();
      times1[i] = endTime1 - startTime1;

      long startTime2 = System.nanoTime();
      prefixAverage2(X);
      long endTime2 = System.nanoTime();
      times2[i] = endTime2 - startTime2;
    }

    // Visualize the running times as a log-log chart
    // You can use popular libraries like JFreeChart or Matplotlib for visualization
  }
}