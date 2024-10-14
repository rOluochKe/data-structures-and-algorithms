package Java;

import java.util.LinkedList;

public class PowerOfTwoChoicesHashing<K, V> {
  private static final int DEFAULT_CAPACITY = 16;

  private int capacity;
  private LinkedList<Entry<K, V>>[] table;

  public PowerOfTwoChoicesHashing() {
    this.capacity = DEFAULT_CAPACITY;
    this.table = new LinkedList[capacity];
    for (int i = 0; i < capacity; i++) {
      table[i] = new LinkedList<>();
    }
  }

  public void put(K key, V value) {
    // Implementation of put method
  }

  public V get(K key) {
    // Implementation of get method
  }

  private int hash1(K key) {
    // First hash function implementation
  }

  private int hash2(K key) {
    // Second hash function implementation
  }

  private class Entry<K, V> {
    private K key;
    private V value;

    public Entry(K key, V value) {
      this.key = key;
      this.value = value;
    }
  }
}