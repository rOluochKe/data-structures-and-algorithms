package Java;

public interface Queue<E> {
  int size();

  boolean isEmpty();

  void enqueue(E e);

  E first();

  E dequeue();
}

public class ArrayQueue<E> implements Queue<E> {
  private E[] data;
  private int f = 0;
  private int sz = 0;

  public ArrayQueue() {
    this(CAPACITY);
  }

  public ArrayQueue(int capacity) {
    data = (E[]) new Object[capacity];
  }

  public int size() {
    return sz;
  }

  public boolean isEmpty() {
    return sz == 0;
  }

  public void enqueue(E e) {
    if (sz == data.length)
      throw new IllegalStateException("Queue is full");
    int avail = (f + sz) % data.length;
    data[avail] = e;
    sz++;
  }

  public E first() {
    if (isEmpty())
      return null;
    return data[f];
  }

  public E dequeue() {
    if (isEmpty())
      return null;
    E answer = data[f];
    data[f] = null;
    f = (f + 1) % data.length;
    sz--;
    return answer;
  }
}