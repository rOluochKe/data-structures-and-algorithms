package Java;

public class CaesarCipher2 {
  public static String encrypt(String message, int shift) {
    StringBuilder result = new StringBuilder();

    for (char c : message.toCharArray()) {
      if (Character.isLetter(c)) {
        char base = Character.isLowerCase(c) ? 'a' : 'A';
        result.append((char) ((c - base + shift) % 26 + base));
      } else {
        result.append(c);
      }
    }

    return result.toString();
  }

  public static String decrypt(String message, int shift) {
    return encrypt(message, 26 - shift);
  }
}
