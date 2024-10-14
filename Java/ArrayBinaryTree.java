package Java;

public class ArrayBinaryTree {
  private int[] treeArray;
  private int size;

  public ArrayBinaryTree(int capacity) {
    treeArray = new int[capacity];
    size = 0;
  }

  public void add(int value) {
    treeArray[size] = value;
    size++;
  }

  public void display() {
    for (int i = 0; i < size; i++) {
      System.out.print(treeArray[i] + " ");
    }
  }

  public static void main(String[] args) {
    ArrayBinaryTree binaryTree = new ArrayBinaryTree(10);
    binaryTree.add(1);
    binaryTree.add(2);
    binaryTree.add(3);

    binaryTree.display();
  }
}