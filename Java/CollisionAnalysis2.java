package Java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class CollisionAnalysis2 {
  public static void main(String[] args) {
    String filename = "phone_numbers.txt";
    HashMap<Integer, Integer> collisions = new HashMap<>();

    // Read phone numbers file and calculate hash codes
    try {
      File file = new File(filename);
      Scanner scanner = new Scanner(file);

      while (scanner.hasNextLine()) {
        String phoneNumber = scanner.nextLine();
        int polynomialHash = calculatePolynomialHash(phoneNumber, 31); // Change 'a' value as needed

        // Count collisions
        if (collisions.containsKey(polynomialHash)) {
          collisions.put(polynomialHash, collisions.get(polynomialHash) + 1);
        } else {
          collisions.put(polynomialHash, 1);
        }
      }

      scanner.close();
    } catch (FileNotFoundException e) {
      System.out.println("File not found.");
    }

    // Display collision rates
    for (int hash : collisions.keySet()) {
      int collisionCount = collisions.get(hash);
      if (collisionCount > 1) {
        System.out.println("Hash: " + hash + " - Collisions: " + collisionCount);
      }
    }
  }

  private static int calculatePolynomialHash(String phoneNumber, int a) {
    int hash = 0;
    for (int i = 0; i < phoneNumber.length(); i++) {
      hash = (a * hash + Character.getNumericValue(phoneNumber.charAt(i))) % Integer.MAX_VALUE;
    }
    return hash;
  }
}