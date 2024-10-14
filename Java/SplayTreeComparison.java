class SplayTreeTopDown<K extends Comparable<K>, V> {
  private Node root;

  private class Node {
    K key;
    V value;
    Node left;
    Node right;

    public Node(K key, V value) {
      this.key = key;
      this.value = value;
    }
  }

  public void insert(K key, V value) {
    // Implement top-down splaying insert operation
  }

  public V search(K key) {
    // Implement top-down splaying search operation
    return null; // Placeholder
  }

  public void remove(K key) {
    // Implement top-down splaying remove operation
  }

  // Other methods for splaying and tree operations
}

public class SplayTreeComparison {
  public static void main(String[] args) {
    // Perform experimental studies to compare top-down splaying to bottom-up
    // splaying
    // Initialize both top-down and bottom-up splay trees
    SplayTreeTopDown<Integer, String> topDownSplayTree = new SplayTreeTopDown<>();
    // Initialize bottom-up splay tree

    // Measure the performance of both techniques for various operations

    // Compare the results and analyze the performance
  }
}