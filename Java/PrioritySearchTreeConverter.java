package Java;

import java.util.*;

class Point {
  int x;
  int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public String toString() {
    return "(" + x + ", " + y + ")";
  }
}

class Node {
  Point point;
  Node left;
  Node right;

  public Node(Point point) {
    this.point = point;
    this.left = null;
    this.right = null;
  }
}

public class PrioritySearchTreeConverter {
  public static void main(String[] args) {
    // Example usage
    List<Point> points = new ArrayList<>();
    points.add(new Point(1, 5));
    points.add(new Point(3, 8));
    points.add(new Point(5, 3));
    points.add(new Point(7, 6));
    points.add(new Point(9, 2));

    Node root = buildPrioritySearchTree(points);

    // Print the priority search tree
    printPrioritySearchTree(root);
  }

  public static Node buildPrioritySearchTree(List<Point> points) {
    // Sort the points by x-coordinate
    points.sort(Comparator.comparingInt(p -> p.x));

    // Build the binary tree
    return buildPrioritySearchTreeHelper(points, 0, points.size() - 1);
  }

  private static Node buildPrioritySearchTreeHelper(List<Point> points, int start, int end) {
    if (start > end) {
      return null;
    }

    int mid = start + (end - start) / 2;
    Node node = new Node(points.get(mid));

    node.left = buildPrioritySearchTreeHelper(points, start, mid - 1);
    node.right = buildPrioritySearchTreeHelper(points, mid + 1, end);

    return node;
  }

  public static void printPrioritySearchTree(Node root) {
    if (root == null) {
      return;
    }

    // Perform in-order traversal to print the priority search tree
    printPrioritySearchTree(root.left);
    System.out.println("Node: " + root.point);
    printPrioritySearchTree(root.right);
  }
}