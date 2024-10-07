package Java;

public class ArrayDeque {
  private int[] arr;
  private int front;
  private int rear;
  private int size;
  private int capacity;

  public ArrayDeque(int capacity) {
    this.capacity = capacity;
    arr = new int[capacity];
    front = 0;
    rear = 0;
    size = 0;
  }

  public void addFirst(int item) {
    if (size == capacity) {
      System.out.println("Deque is full");
      return;
    }
    front = (front - 1 + capacity) % capacity;
    arr[front] = item;
    size++;
  }

  public void addLast(int item) {
    if (size == capacity) {
      System.out.println("Deque is full");
      return;
    }
    arr[rear] = item;
    rear = (rear + 1) % capacity;
    size++;
  }

  public int removeFirst() {
    if (size == 0) {
      System.out.println("Deque is empty");
      return -1;
    }
    int removed = arr[front];
    front = (front + 1) % capacity;
    size--;
    return removed;
  }

  public int removeLast() {
    if (size == 0) {
      System.out.println("Deque is empty");
      return -1;
    }
    rear = (rear - 1 + capacity) % capacity;
    int removed = arr[rear];
    size--;
    return removed;
  }

  public static void main(String[] args) {
    ArrayDeque deque = new ArrayDeque(5);
    deque.addLast(1);
    deque.addFirst(2);
    deque.addLast(3);
    deque.addFirst(4);

    System.out.println(deque.removeFirst()); // Should remove 4
    System.out.println(deque.removeLast()); // Should remove 3
  }
}