package Java;

class BinaryNode {
  int data;
  BinaryNode parent;
  BinaryNode leftChild;
  BinaryNode rightChild;

  public BinaryNode(int data, BinaryNode parent) {
    this.data = data;
    this.parent = parent;
    this.leftChild = null;
    this.rightChild = null;
  }
}

public class BinaryTree {
  private BinaryNode root;

  public BinaryTree() {
    root = null;
  }

  public BinaryNode addRoot(int data) {
    if (root != null) {
      throw new IllegalStateException("Tree already has a root");
    }
    root = new BinaryNode(data, null);
    return root;
  }

  public BinaryNode addLeftChild(BinaryNode parent, int data) {
    if (parent.leftChild != null) {
      throw new IllegalStateException("Left child already exists");
    }
    parent.leftChild = new BinaryNode(data, parent);
    return parent.leftChild;
  }

  public BinaryNode addRightChild(BinaryNode parent, int data) {
    if (parent.rightChild != null) {
      throw new IllegalStateException("Right child already exists");
    }
    parent.rightChild = new BinaryNode(data, parent);
    return parent.rightChild;
  }

  // Add other update methods as needed

  public static void main(String[] args) {
    BinaryTree tree = new BinaryTree();
    BinaryNode root = tree.addRoot(1);
    BinaryNode leftChild = tree.addLeftChild(root, 2);
    BinaryNode rightChild = tree.addRightChild(root, 3);

    System.out.println("Root: " + root.data);
    System.out.println("Left Child: " + leftChild.data);
    System.out.println("Right Child: " + rightChild.data);
  }
}