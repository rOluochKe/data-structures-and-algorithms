package Java;

public class TopTenScores {
  private Node head;
  private int size;

  private class Node {
    int score;
    Node next;

    Node(int score) {
      this.score = score;
      this.next = null;
    }
  }

  public void add(int score) {
    Node newNode = new Node(score);
    if (head == null || score > head.score) {
      newNode.next = head;
      head = newNode;
    } else {
      Node current = head;
      while (current.next != null && score < current.next.score) {
        current = current.next;
      }
      newNode.next = current.next;
      current.next = newNode;
    }

    if (size == 10) {
      removeLast();
    } else {
      size++;
    }
  }

  public void remove(int score) {
    if (head == null) {
      return;
    }

    if (head.score == score) {
      head = head.next;
      size--;
      return;
    }

    Node current = head;
    while (current.next != null && current.next.score != score) {
      current = current.next;
    }

    if (current.next != null) {
      current.next = current.next.next;
      size--;
    }
  }

  private void removeLast() {
    if (head == null) {
      return;
    }

    if (head.next == null) {
      head = null;
      size--;
      return;
    }

    Node current = head;
    while (current.next.next != null) {
      current = current.next;
    }

    current.next = null;
    size--;
  }
}