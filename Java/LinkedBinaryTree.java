import java.util.ArrayList;
import java.util.List;

class BinaryNode {
  int data;
  BinaryNode leftChild;
  BinaryNode rightChild;

  public BinaryNode(int data) {
    this.data = data;
    this.leftChild = null;
    this.rightChild = null;
  }
}

class Position {
  List<BinaryNode> path;

  public Position() {
    path = new ArrayList<>();
  }

  public void addToPath(BinaryNode node) {
    path.add(node);
  }

  public BinaryNode getNodeAtDepth(int depth) {
    return path.get(depth);
  }
}

public class LinkedBinaryTree {
  private BinaryNode root;

  public LinkedBinaryTree() {
    root = null;
  }

  public Position addRoot(int data) {
    if (root != null) {
      throw new IllegalStateException("Tree already has a root");
    }
    root = new BinaryNode(data);

    Position rootPosition = new Position();
    rootPosition.addToPath(root);
    return rootPosition;
  }

  public Position addLeftChild(Position parentPosition, int data) {
    BinaryNode parent = parentPosition.getNodeAtDepth(parentPosition.path.size() - 1);
    parent.leftChild = new BinaryNode(data);

    Position leftChildPosition = new Position();
    leftChildPosition.path = new ArrayList<>(parentPosition.path);
    leftChildPosition.addToPath(parent.leftChild);
    return leftChildPosition;
  }

  public Position addRightChild(Position parentPosition, int data) {
    BinaryNode parent = parentPosition.getNodeAtDepth(parentPosition.path.size() - 1);
    parent.rightChild = new BinaryNode(data);

    Position rightChildPosition = new Position();
    rightChildPosition.path = new ArrayList<>(parentPosition.path);
    rightChildPosition.addToPath(parent.rightChild);
    return rightChildPosition;
  }

  // Add other methods as needed

  public static void main(String[] args) {
    LinkedBinaryTree tree = new LinkedBinaryTree();
    Position rootPosition = tree.addRoot(1);
    Position leftChildPosition = tree.addLeftChild(rootPosition, 2);
    Position rightChildPosition = tree.addRightChild(rootPosition, 3);

    System.out.println("Root: " + rootPosition.getNodeAtDepth(0).data);
    System.out.println("Left Child: " + leftChildPosition.getNodeAtDepth(1).data);
    System.out.println("Right Child: " + rightChildPosition.getNodeAtDepth(1).data);
  }
}