package Java;

public class TwoColorDoubleStack {
  private int[] arr;
  private int redTop;
  private int blueTop;
  private int capacity;

  public TwoColorDoubleStack(int capacity) {
    this.capacity = capacity;
    arr = new int[capacity];
    redTop = -1;
    blueTop = capacity;
  }

  public void redPush(int item) {
    if (redTop + 1 < blueTop) {
      arr[++redTop] = item;
    } else {
      System.out.println("Red stack is full");
    }
  }

  public void bluePush(int item) {
    if (blueTop - 1 > redTop) {
      arr[--blueTop] = item;
    } else {
      System.out.println("Blue stack is full");
    }
  }

  public int redPop() {
    if (redTop >= 0) {
      return arr[redTop--];
    } else {
      System.out.println("Red stack is empty");
      return -1;
    }
  }

  public int bluePop() {
    if (blueTop < capacity) {
      return arr[blueTop++];
    } else {
      System.out.println("Blue stack is empty");
      return -1;
    }
  }

  public static void main(String[] args) {
    TwoColorDoubleStack stack = new TwoColorDoubleStack(10);
    stack.redPush(5);
    stack.redPush(3);
    stack.bluePush(9);

    System.out.println("Red popped: " + stack.redPop());
    System.out.println("Blue popped: " + stack.bluePop());
  }
}