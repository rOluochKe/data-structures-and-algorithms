package Java;

import java.util.Scanner;

public interface Map<K, V> {
  int size();

  boolean isEmpty();

  V get(K key);

  V put(K key, V value);

  V remove(K key);

  Iterable<K> keySet();

  Iterable<V> values();

  Iterable<Entry<K, V>> entrySet();
}

public class WordCount {
  public static void main(String[] args) {
    Map<String, Integer> freq = new ChainHashMap<>();
    Scanner doc = new Scanner(System.in).useDelimiter("[^a-zA-Z]+");
    while (doc.hasNext()) {
      String word = doc.next().toLowerCase();
      Integer count = freq.get(word);
      if (count == null)
        count = 0;
      freq.put(word, count + 1);
    }
    int maxCount = 0;
    String maxWord = "no word";
    for (Entry<String, Integer> ent : freq.entrySet())
      if (ent.getValue() > maxCount) {
        maxWord = ent.getKey();
        maxCount = ent.getValue();
      }
    System.out.println("The most frequent word id '" + maxWord);
    System.out.println("' with " + maxCount + " occurrences.");
  }
}