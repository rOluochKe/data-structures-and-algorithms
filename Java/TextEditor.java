package Java;

public class TextEditor {
  private LinkedPositionalList<Character> text;
  private Position<Character> cursor;

  // Constructor
  public TextEditor() {
    text = new LinkedPositionalList<>();
    cursor = null;
  }

  // Move cursor left one character
  public void left() {
    if (cursor != null && cursor != text.first()) {
      cursor = text.before(cursor);
    }
  }

  // Move cursor right one character
  public void right() {
    if (cursor != null && cursor != text.last()) {
      cursor = text.after(cursor);
    }
  }

  // Insert the character c just after the cursor
  public void insert(char c) {
    Position<Character> newPos = text.addAfter(cursor, c);
    cursor = newPos;
  }

  // Delete the character just after the cursor
  public void delete() {
    if (cursor != null && cursor != text.last()) {
      Position<Character> toDelete = text.after(cursor);
      text.remove(toDelete);
    }
  }

  // Display the text with cursor position highlighted
  public String display() {
    StringBuilder sb = new StringBuilder();
    for (Character c : text) {
      if (cursor != null && cursor.getElement() == c) {
        sb.append("|" + c + "|");
      } else {
        sb.append(c);
      }
    }
    if (cursor == null || cursor == text.last()) {
      sb.append("|");
    }
    return sb.toString();
  }
}