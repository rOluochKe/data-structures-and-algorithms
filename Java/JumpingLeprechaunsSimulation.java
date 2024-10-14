package Java;

import java.util.Random;

public class JumpingLeprechaunsSimulation {
  static class Leprechaun {
    int id;
    double goldValue;
    double horizonPlace;

    public Leprechaun(int id, double goldValue, double horizonPlace) {
      this.id = id;
      this.goldValue = goldValue;
      this.horizonPlace = horizonPlace;
    }

    public void computeNewPlace(double randomFactor) {
      // Compute a new place on the horizon for the leprechaun
      this.horizonPlace += randomFactor;
    }
  }

  public static void main(String[] args) {
    int n = 5; // Number of leprechauns
    Leprechaun[] leprechauns = new Leprechaun[n];

    // Initialize leprechauns with gold value and horizon place
    for (int i = 0; i < n; i++) {
      leprechauns[i] = new Leprechaun(i + 1, 1000000, 0.0); // Gold value starts at 1,000,000 and place on the horizon
                                                            // starts at 0
    }

    Random random = new Random();

    // Simulate iterations
    for (int iteration = 1; iteration <= 10; iteration++) {
      System.out.println("Iteration " + iteration + ":");
      for (int i = 0; i < n; i++) {
        double randomFactor = random.nextDouble(); // Generate a random factor for computing new place
        leprechauns[i].computeNewPlace(randomFactor);
        System.out.println("Leprechaun " + leprechauns[i].id + " - Gold: " + leprechauns[i].goldValue
            + ", Horizon Place: " + leprechauns[i].horizonPlace);
      }
      System.out.println();
    }
  }
}