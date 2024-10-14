package Java;

import java.util.HashMap;
import java.util.LinkedList;

public class LinkedHashMap<K, V> {
  private HashMap<K, V> map;
  private LinkedList<K> order;

  public LinkedHashMap() {
    map = new HashMap<>();
    order = new LinkedList<>();
  }

  public void put(K key, V value) {
    if (map.containsKey(key)) {
      order.remove(key);
    }
    map.put(key, value);
    order.addLast(key);
  }

  public V get(K key) {
    if (map.containsKey(key)) {
      order.remove(key);
      order.addLast(key);
      return map.get(key);
    }
    return null;
  }

  public void remove(K key) {
    if (map.containsKey(key)) {
      map.remove(key);
      order.remove(key);
    }
  }

  public K getFirstKey() {
    if (!order.isEmpty()) {
      return order.getFirst();
    }
    return null;
  }
}