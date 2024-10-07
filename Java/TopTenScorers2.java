package Java;

public class TopTenScorers2 {
  private Node head;
  private Node tail;
  private int size;

  private class Node {
    int score;
    Node prev;
    Node next;

    Node(int score) {
      this.score = score;
      this.prev = null;
      this.next = null;
    }
  }

  public void add(int score) {
    Node newNode = new Node(score);
    if (head == null || score > head.score) {
      newNode.next = head;
      if (head != null) {
        head.prev = newNode;
      }
      head = newNode;
      if (tail == null) {
        tail = head;
      }
    } else {
      Node current = head;
      while (current.next != null && score < current.next.score) {
        current = current.next;
      }
      newNode.next = current.next;
      if (current.next != null) {
        current.next.prev = newNode;
      }
      current.next = newNode;
      newNode.prev = current;
    }

    if (size == 10) {
      removeLast();
    } else {
      size++;
    }
  }

  public void remove(int index) {
    if (head == null || index >= size) {
      return;
    }

    if (index == 0) {
      head = head.next;
      if (head != null) {
        head.prev = null;
      }
      size--;
      return;
    }

    if (index == size - 1) {
      tail = tail.prev;
      tail.next = null;
      size--;
      return;
    }

    Node current = head;
    for (int i = 0; i < index; i++) {
      current = current.next;
    }

    current.prev.next = current.next;
    current.next.prev = current.prev;
    size--;
  }

  private void removeLast() {
    if (head == null) {
      return;
    }

    if (head.next == null) {
      head = null;
      tail = null;
      size--;
      return;
    }

    tail = tail.prev;
    tail.next = null;
    size--;
  }
}
