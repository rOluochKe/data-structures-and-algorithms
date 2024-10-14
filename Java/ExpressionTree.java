package Java;

import java.util.Stack;

class Node {
  String value;
  Node left;
  Node right;

  public Node(String value) {
    this.value = value;
    this.left = null;
    this.right = null;
  }
}

public class ExpressionTree {
  public static Node constructExpressionTree(String expression) {
    Stack<Node> stack = new Stack<>();

    String[] tokens = expression.split(" ");
    for (String token : tokens) {
      if (token.equals("(")) {
        continue;
      } else if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
        Node newNode = new Node(token);
        newNode.right = stack.pop();
        newNode.left = stack.pop();
        stack.push(newNode);
      } else if (token.matches("\\d+|x\\d+")) {
        stack.push(new Node(token));
      }
    }

    return stack.pop();
  }

  public static int evaluate(Node root) {
    if (root == null) {
      return 0;
    }

    if (root.value.matches("\\d+")) {
      return Integer.parseInt(root.value);
    } else if (root.value.matches("x\\d+")) {
      return 0; // Placeholder for variable evaluation
    } else {
      int leftVal = evaluate(root.left);
      int rightVal = evaluate(root.right);

      switch (root.value) {
        case "+":
          return leftVal + rightVal;
        case "-":
          return leftVal - rightVal;
        case "*":
          return leftVal * rightVal;
        case "/":
          return leftVal / rightVal;
        default:
          return 0;
      }
    }
  }

  public static void main(String[] args) {
    String expression = "( + 3 ( * 4 7 ) )"; // Example arithmetic expression
    Node root = constructExpressionTree(expression);

    System.out.println("Value at root: " + evaluate(root));
  }
}