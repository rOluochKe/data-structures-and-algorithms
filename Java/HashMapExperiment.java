package Java;

import java.util.Random;

public class HashMapExperiment {

  public static void main(String[] args) {
    ChainHashMap<Integer, String> chainHashMap = new ChainHashMap<>();
    ProbeHashMap<Integer, String> probeHashMap = new ProbeHashMap<>();
    Random random = new Random();

    int numKeys = 1000;
    int limit = 10;

    // Fill HashMaps with random key-value pairs
    for (int i = 0; i < numKeys; i++) {
      int key = random.nextInt(numKeys);
      String value = "Value" + key;
      chainHashMap.put(key, value);
      probeHashMap.put(key, value);
    }

    // Measure efficiency for various load factors
    for (int loadFactorLimit = 1; loadFactorLimit <= limit; loadFactorLimit++) {
      long startTime = System.nanoTime();

      // Perform operations on ChainHashMap with current load factor limit
      chainHashMap.setLoadFactor(limit / 10.0);

      // Perform operations on ProbeHashMap with current load factor limit
      probeHashMap.setLoadFactor(limit / 10.0);

      long endTime = System.nanoTime();
      long duration = (endTime - startTime) / 1000000; // Convert to milliseconds
      System.out.println("Time taken for load factor " + (limit / 10.0) + ": " + duration + " ms");
    }
  }
}