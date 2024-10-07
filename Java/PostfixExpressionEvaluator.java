package Java;

import java.util.Stack;

public class PostfixExpressionEvaluator {

  public static int evaluatePostfixExpression(String expression) {
    Stack<Integer> stack = new Stack<>();

    for (char c : expression.toCharArray()) {
      if (Character.isDigit(c)) {
        stack.push(c - '0');
      } else {
        int operand2 = stack.pop();
        int operand1 = stack.pop();
        int result = evaluateOperation(c, operand1, operand2);
        stack.push(result);
      }
    }

    return stack.pop();
  }

  public static int evaluateOperation(char operator, int operand1, int operand2) {
    switch (operator) {
      case '+':
        return operand1 + operand2;
      case '-':
        return operand1 - operand2;
      case '*':
        return operand1 * operand2;
      case '/':
        if (operand2 == 0) {
          throw new ArithmeticException("Division by zero!");
        }
        return operand1 / operand2;
      default:
        throw new IllegalArgumentException("Invalid operator: " + operator);
    }
  }

  public static void main(String[] args) {
    String postfixExpression = "34+2*";
    int result = evaluatePostfixExpression(postfixExpression);
    System.out.println("Result of the postfix expression evaluation: " + result);
  }
}