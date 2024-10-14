package Java;

class TreeMap<K, V> {
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

  public void put(K key, V value) {
    if (root == null) {
      root = new Node(key, value);
    } else {
      putRecursive(root, key, value);
    }
  }

  private void putRecursive(Node node, K key, V value) {
    // Implement the logic to traverse the tree and insert the key-value pair
    // Handle cases where the left or right child is null
    // Update the existing value if the key already exists
  }

  // Other methods like get, remove, etc.
}