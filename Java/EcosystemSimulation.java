package Java;

import java.util.Random;

public class EcosystemSimulation {
  private static final int ARRAY_SIZE = 10;
  private static final double BEAR_CREATION_PROBABILITY = 0.02;
  private static final double FISH_CREATION_PROBABILITY = 0.05;

  public static void main(String[] args) {
    Animal[][] river = new Animal[ARRAY_SIZE][ARRAY_SIZE];
    Random random = new Random();

    // Initialize river with animals
    for (int i = 0; i < ARRAY_SIZE; i++) {
      for (int j = 0; j < ARRAY_SIZE; j++) {
        double rand = random.nextDouble();
        if (rand < BEAR_CREATION_PROBABILITY) {
          river[i][j] = new Bear();
        } else if (rand < FISH_CREATION_PROBABILITY) {
          river[i][j] = new Fish();
        }
      }
    }

    // Simulate the ecosystem
    for (int timeStep = 1; timeStep <= 10; timeStep++) {
      System.out.println("Time Step: " + timeStep);
      printRiver(river);

      Animal[][] newRiver = new Animal[ARRAY_SIZE][ARRAY_SIZE];

      for (int i = 0; i < ARRAY_SIZE; i++) {
        for (int j = 0; j < ARRAY_SIZE; j++) {
          if (river[i][j] != null) {
            Animal newAnimal = river[i][j].move(river, i, j);
            if (newAnimal != null) {
              newRiver[i][j] = newAnimal;
            }
          }
        }
      }

      river = newRiver;
    }
  }

  private static void printRiver(Animal[][] river) {
    for (int i = 0; i < ARRAY_SIZE; i++) {
      for (int j = 0; j < ARRAY_SIZE; j++) {
        if (river[i][j] instanceof Bear) {
          System.out.print("B ");
        } else if (river[i][j] instanceof Fish) {
          System.out.print("F ");
        } else {
          System.out.print(". ");
        }
      }
      System.out.println();
    }
    System.out.println();
  }
}

abstract class Animal {
  abstract Animal move(Animal[][] river, int i, int j);
}

class Bear extends Animal {
  @Override
  Animal move(Animal[][] river, int i, int j) {
    // Bear logic for movement
    return null;
  }
}

class Fish extends Animal {
  @Override
  Animal move(Animal[][] river, int i, int j) {
    // Fish logic for movement
    return null;
  }
}