package Java;

import java.util.HashMap;
import java.util.Map;

public class SubstitutionCipher {
  private Map<Character, Character> encodeMap;
  private Map<Character, Character> decodeMap;

  public SubstitutionCipher(String key) {
    encodeMap = new HashMap<>();
    decodeMap = new HashMap<>();

    for (int i = 0; i < 26; i++) {
      char keyChar = (char) ('A' + i);
      char encodeChar = key.charAt(i);
      encodeMap.put(keyChar, encodeChar);
      decodeMap.put(encodeChar, keyChar);
    }
  }

  public String encode(String message) {
    StringBuilder result = new StringBuilder();

    for (char c : message.toCharArray()) {
      if (Character.isUpperCase(c)) {
        result.append(encodeMap.get(c));
      } else {
        result.append(c);
      }
    }

    return result.toString();
  }

  public String decode(String message) {
    StringBuilder result = new StringBuilder();

    for (char c : message.toCharArray()) {
      if (Character.isUpperCase(c)) {
        result.append(decodeMap.get(c));
      } else {
        result.append(c);
      }
    }

    return result.toString();
  }
}

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomCipher extends SubstitutionCipher {
  public RandomCipher() {
    super(generateRandomKey());
  }

  private static String generateRandomKey() {
    List<Character> letters = new ArrayList<>();
    for (int i = 0; i < 26; i++) {
      letters.add((char) ('A' + i));
    }
    Collections.shuffle(letters, new Random());

    StringBuilder key = new StringBuilder();
    for (char c : letters) {
      key.append(c);
    }

    return key.toString();
  }
}