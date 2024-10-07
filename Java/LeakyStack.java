package Java;

public class LeakyStack {
  private int[] arr;
  private int top;
  private int size;
  private int capacity;

  public LeakyStack(int capacity) {
    this.capacity = capacity;
    arr = new int[capacity];
    top = 0;
    size = 0;
  }

  public void push(int item) {
    if (size == capacity) {
      top = (top + 1) % capacity; // Leak the oldest element from the bottom
    } else {
      size++;
    }
    arr[top] = item;
    top = (top + 1) % capacity;
  }

  public int pop() {
    if (size == 0) {
      System.out.println("Stack is empty");
      return -1;
    } else {
      top = (top + capacity - 1) % capacity;
      int popped = arr[top];
      size--;
      return popped;
    }
  }

  public static void main(String[] args) {
    LeakyStack stack = new LeakyStack(5);
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