package Java;

import java.util.Scanner;

public class SimpleCalculator {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    double result = 0;

    System.out.println("Welcome to Simple Calculator!");

    while (true) {
      System.out.print("Enter number or operator (+, -, *, /, =): ");
      String input = scanner.nextLine();

      if (input.equals("=")) {
        System.out.println("Result: " + result);
        break;
      }

      if (isOperator(input)) {
        char operator = input.charAt(0);
        System.out.print("Enter number: ");
        double number = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        switch (operator) {
          case '+':
            result += number;
            break;
          case '-':
            result -= number;
            break;
          case '*':
            result *= number;
            break;
          case '/':
            if (number != 0) {
              result /= number;
            } else {
              System.out.println("Error: Division by zero");
            }
            break;
          default:
            System.out.println("Invalid operator");
        }
      } else {
        System.out.println("Invalid input");
      }
    }

    scanner.close();
  }

  private static boolean isOperator(String input) {
    return input.length() == 1 && "+-*/=".contains(input);
  }
}