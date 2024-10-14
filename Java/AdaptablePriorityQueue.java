package Java;

import java.util.ArrayList;
import java.util.List;

public class AdaptablePriorityQueue<K, V> {
  private List<Entry<K, V>> queue;

  public AdaptablePriorityQueue() {
    queue = new ArrayList<>();
  }

  private static class Entry<K, V> {
    K key;
    V value;

    Entry(K key, V value) {
      this.key = key;
      this.value = value;
    }
  }

  public void insert(K key, V value) {
    Entry<K, V> newEntry = new Entry<>(key, value);
    queue.add(newEntry);
  }

  public V remove(K key) {
    for (int i = 0; i < queue.size(); i++) {
      Entry<K, V> entry = queue.get(i);
      if (entry.key.equals(key)) {
        queue.remove(i);
        return entry.value;
      }
    }
    return null;
  }

  public void replaceKey(K oldKey, K newKey) {
    for (Entry<K, V> entry : queue) {
      if (entry.key.equals(oldKey)) {
        entry.key = newKey;
        return;
      }
    }
  }

  public void replaceValue(K key, V newValue) {
    for (Entry<K, V> entry : queue) {
      if (entry.key.equals(key)) {
        entry.value = newValue;
        return;
      }
    }
  }

  public void printQueue() {
    for (Entry<K, V> entry : queue) {
      System.out.println("Key: " + entry.key + ", Value: " + entry.value);
    }
  }

  public static void main(String[] args) {
    AdaptablePriorityQueue<Integer, String> pq = new AdaptablePriorityQueue<>();
    pq.insert(1, "One");
    pq.insert(2, "Two");
    pq.insert(3, "Three");

    pq.printQueue();

    pq.replaceKey(2, 4);
    pq.replaceValue(3, "New Three");

    System.out.println("After replacements:");
    pq.printQueue();

    String removedValue = pq.remove(1);
    System.out.println("Removed value: " + removedValue);

    System.out.println("Final queue:");
    pq.printQueue();
  }
}