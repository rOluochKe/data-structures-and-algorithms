package Java;

import java.util.ArrayList;
import java.util.List;

class StockOrder {
  String type;
  double price;

  public StockOrder(String type, double price) {
    this.type = type;
    this.price = price;
  }
}

public class StockOrderProcessor {
  private List<StockOrder> orders;

  public StockOrderProcessor() {
    orders = new ArrayList<>();
  }

  public void addOrder(String type, double price) {
    StockOrder order = new StockOrder(type, price);
    orders.add(order);
  }

  public double calculateProfitLoss() {
    double totalProfitLoss = 0;
    double buyPrice = -1;

    for (StockOrder order : orders) {
      if (order.type.equalsIgnoreCase("buy")) {
        if (buyPrice == -1) {
          buyPrice = order.price;
        }
      } else if (order.type.equalsIgnoreCase("sell")) {
        if (buyPrice != -1) {
          totalProfitLoss += (order.price - buyPrice);
          buyPrice = -1;
        }
      }
    }

    return totalProfitLoss;
  }

  public static void main(String[] args) {
    StockOrderProcessor processor = new StockOrderProcessor();

    processor.addOrder("buy", 100.0);
    processor.addOrder("sell", 120.0);
    processor.addOrder("sell", 105.0);
    processor.addOrder("buy", 110.0);

    double profitLoss = processor.calculateProfitLoss();
    System.out.println("Total Profit/Loss: $" + profitLoss);
  }
}