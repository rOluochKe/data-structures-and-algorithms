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

public class SlicingFloorPlan {
  public static double calculateMinimumHeight(Node node, double minWidth, double minHeight) {
    if (node == null) {
      return 0;
    }

    if (node.left == null && node.right == null) { // External node representing basic rectangle
      String[] nodeValues = node.value.split(",");
      double width = Double.parseDouble(nodeValues[0]);
      double height = Double.parseDouble(nodeValues[1]);
      return Math.max(minHeight, minWidth / width); // Ensure height is at least minHeight
    }

    double leftWidth = calculateWidth(node.left, minWidth, minHeight);
    double rightWidth = calculateWidth(node.right, minWidth, minHeight);

    return Math.max(leftWidth, rightWidth);
  }

  public static double calculateWidth(Node node, double minWidth, double minHeight) {
    if (node == null) {
      return 0;
    }

    if (node.left == null && node.right == null) { // External node representing basic rectangle
      String[] nodeValues = node.value.split(",");
      double width = Double.parseDouble(nodeValues[0]);
      double height = Double.parseDouble(nodeValues[1]);
      return Math.max(minWidth, minHeight * height); // Ensure width is at least minWidth
    }

    double leftWidth = calculateWidth(node.left, minWidth, minHeight);
    double rightWidth = calculateWidth(node.right, minWidth, minHeight);

    return leftWidth + rightWidth;
  }

  public static void main(String[] args) {
    Node root = new Node("/");
    root.left = new Node("2"); // Horizontal cut
    root.right = new Node("/");
    root.right.left = new Node("3"); // Vertical cut
    root.right.right = new Node("4,5"); // Basic rectangle

    double minWidth = 2;
    double minHeight = 1;

    double smallestPossibleHeight = calculateMinimumHeight(root, minWidth, minHeight);
    System.out.println("Smallest possible height for the slicing floor plan: " + smallestPossibleHeight);
  }
}