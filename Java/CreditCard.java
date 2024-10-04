package Java;

/**
 * A simple model for a customer credit card.
 *
 * This class represents a credit card with customer information, bank details,
 * account number, credit limit, and balance.
 *
 * @author John Doe
 * @author Jane Doe
 * @author Mary Doe
 */
public class CreditCard {
  private String customer;
  private String bank;
  private String account;
  private int limit;
  protected double balance;

  /**
   * Constructs a new CreditCard instance with the provided customer information.
   *
   * @param cust       the name of the customer (e.g. 'John Doe')
   * @param bk         the name of the bank (e.g. '1st Bank')
   * @param acnt       the account number (e.g. '5399 0375 9387 5309')
   * @param lim        the credit limit (measured in dollars)
   * @param initialBal the initial balance (measured in dollars)
   */
  public CreditCard(String cust, String bk, String acnt, int lim, double initialBal) {
    customer = cust;
    bank = bk;
    account = acnt;
    limit = lim;
    balance = initialBal;
  }

  /**
   * Constructs a new CreditCard instance with the provided customer information
   * and sets the initial balance to 0.
   *
   * @param cust the name of the customer
   * @param bk   the name of the bank
   * @param acnt the account number
   * @param lim  the credit limit
   */
  public CreditCard(String cust, String bk, String acnt, int lim) {
    this(cust, bk, acnt, lim, 0.0);
  }

  // Accessor methods
  public String getCustomer() {
    return customer;
  }

  public String getBank() {
    return bank;
  }

  public String getAccount() {
    return account;
  }

  public int getLimit() {
    return limit;
  }

  public double getBalance() {
    return balance;
  }

  // Mutator methods
  /**
   * Charges the given price to the credit card if within the credit limit.
   *
   * @param price the amount to charge
   * @return true if the charge is successful, false if it exceeds the credit
   *         limit
   */
  public boolean charge(double price) {
    if (price + balance > limit) {
      return false;
    }
    balance += price;
    return true;
  }

  /**
   * Makes a payment towards the credit card balance.
   *
   * @param payment the amount to pay
   */
  public void makePayment(double payment) {
    balance -= payment;
  }

  // Utility methods
  /**
   * Prints a summary of the credit card's information.
   *
   * @param card the credit card to print the summary for
   */
  public static void printSummary(CreditCard card) {
    System.out.println("Customer: " + card.customer);
    System.out.println("Bank: " + card.bank);
    System.out.println("Account = " + card.account);
    System.out.println("Limit = " + card.limit);
    System.out.println("Balance = " + card.balance);
  }

  /**
   * Main method to demonstrate the usage of the CreditCard class.
   *
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    CreditCard[] wallet = new CreditCard[3];
    wallet[0] = new CreditCard("John Doe", "1st Bank", "5399 0375 9387 5309", 2500);
    wallet[1] = new CreditCard("Jane Doe", "2nd Bank", "4599 0375 9387 5467", 3500);
    wallet[2] = new CreditCard("Mary Doe", "3rd Bank", "2345 0375 6567 0967", 5000);

    for (int val = 1; val <= 16; val++) {
      wallet[0].charge(val);
      wallet[1].charge(2 * val);
      wallet[2].charge(3 * val);
    }

    for (CreditCard card : wallet) {
      CreditCard.printSummary(card);
      while (card.getBalance() > 200) {
        card.makePayment(200);
        System.out.println("New balance = " + card.getBalance());
      }
    }
  }
}