package Java;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MultiMap<K extends Comparable<K>, V> {
  private Node root;

  private class Node {
    K key;
    Collection<V> values;
    Node left;
    Node right;

    public Node(K key, V value) {
      this.key = key;
      this.values = new ArrayList<>();
      this.values.add(value);
    }
  }

  public void put(K key, V value) {
    root = putRecursive(root, key, value);
  }

  private Node putRecursive(Node node, K key, V value) {
    if (node == null) {
      return new Node(key, value);
    }

    int cmp = key.compareTo(node.key);
    if (cmp < 0) {
      node.left = putRecursive(node.left, key, value);
    } else if (cmp > 0) {
      node.right = putRecursive(node.right, key, value);
    } else {
      node.values.add(value);
    }

    return node;
  }

  public Collection<V> get(K key) {
    return getRecursive(root, key);
  }

  private Collection<V> getRecursive(Node node, K key) {
    if (node == null) {
      return null;
    }

    int cmp = key.compareTo(node.key);
    if (cmp < 0) {
      return getRecursive(node.left, key);
    } else if (cmp > 0) {
      return getRecursive(node.right, key);
    } else {
      return node.values;
    }
  }

  // Other methods like remove, containsKey, keySet, etc.
}