package Java;

public class LeakyStackLinkedList {
  private class Node {
    int data;
    Node next;

    Node(int data) {
      this.data = data;
    }
  }

  private Node head;
  private int size;
  private int capacity;

  public LeakyStackLinkedList(int capacity) {
    this.capacity = capacity;
    head = null;
    size = 0;
  }

  public void push(int item) {
    if (size == capacity) {
      Node temp = head;
      head = head.next;
      temp.next = null;
      size--;
    }

    Node newNode = new Node(item);
    newNode.next = head;
    head = newNode;
    size++;
  }

  public int pop() {
    if (size == 0) {
      System.out.println("Stack is empty");
      return -1;
    }

    int popped = head.data;
    head = head.next;
    size--;
    return popped;
  }

  public static void main(String[] args) {
    LeakyStackLinkedList stack = new LeakyStackLinkedList(5);
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    stack.push(5); // Stack is now at full capacity
    stack.push(6); // 1 will be replaced by 6 (oldest element leaked)

    System.out.println("Popped: " + stack.pop()); // Should pop 6
    System.out.println("Popped: " + stack.pop()); // Should pop 2
  }
}