package Java;

import java.util.TreeMap;

public class ABTreeSortedMap<K extends Comparable<K>, V> {
  private TreeMap<K, V> map;
  private int a;
  private int b;

  public ABTreeSortedMap(int a, int b) {
    this.a = a;
    this.b = b;
    this.map = new TreeMap<>();
  }

  public void put(K key, V value) {
    map.put(key, value);
  }

  public V get(K key) {
    return map.get(key);
  }

  public void remove(K key) {
    map.remove(key);
  }

  // Implement other methods of the sorted map ADT based on (a, b) tree rules
  // such as finding predecessor, successor, range queries, etc.
}