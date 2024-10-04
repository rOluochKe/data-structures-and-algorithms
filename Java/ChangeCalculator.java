package Java;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ChangeCalculator {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter the amount charged: ");
    double amountCharged = scanner.nextDouble();
    System.out.print("Enter the amount given: ");
    double amountGiven = scanner.nextDouble();

    double change = amountGiven - amountCharged;

    calculateChange(change);
  }

  private static void calculateChange(double change) {
    int[] coins = { 100, 50, 20, 10, 5, 1 };
    int[] bills = { 100, 50, 20, 10, 5, 1 };

    Map<Integer, Integer> changeMap = new HashMap<>();

    for (int bill : bills) {
      int count = (int) (change / bill);
      if (count > 0) {
        changeMap.put(bill, count);
        change -= count * bill;
      }
    }

    for (int coin : coins) {
      int count = (int) (change / coin);
      if (count > 0) {
        changeMap.put(coin, count);
        change -= count * coin;
      }
    }

    System.out.println("Change to give back:");
    for (Map.Entry<Integer, Integer> entry : changeMap.entrySet()) {
      System.out.println(entry.getKey() + ": " + entry.getValue());
    }
  }
}