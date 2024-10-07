package Java;

import java.util.*;

public class StockCapitalGainCalculator {

  public static int calculateCapitalGain(String[] transactions) {
    Queue<Integer> sharesBought = new LinkedList<>();
    Queue<Integer> pricesBought = new LinkedList<>();
    int capitalGain = 0;

    for (String transaction : transactions) {
      String[] parts = transaction.split(" ");
      int amount = Integer.parseInt(parts[1]);
      int price = Integer.parseInt(parts[3]);

      if (parts[0].equals("buy")) {
        sharesBought.offer(amount);
        pricesBought.offer(price);
      } else if (parts[0].equals("sell")) {
        int remainingSharesToSell = amount;
        while (!sharesBought.isEmpty() && remainingSharesToSell > 0) {
          int shares = sharesBought.peek();
          int priceBought = pricesBought.peek();
          int sharesSold = Math.min(shares, remainingSharesToSell);

          capitalGain += sharesSold * (price - priceBought);

          remainingSharesToSell -= sharesSold;
          sharesBought.poll();
          pricesBought.poll();

          if (shares > sharesSold) {
            sharesBought.offer(shares - sharesSold);
            pricesBought.offer(priceBought);
          }
        }
      }
    }

    return capitalGain;
  }

  public static void main(String[] args) {
    String[] transactions = {
        "buy 100 shares at $20 each",
        "buy 20 shares at $24 each",
        "buy 200 shares at $36 each",
        "sell 150 shares at $30 each"
    };

    int totalCapitalGain = calculateCapitalGain(transactions);
    System.out.println("Total capital gain: $" + totalCapitalGain);
  }
}