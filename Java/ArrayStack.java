package Java;

import java.util.Stack;

public interface Stack<E> {
  int size();

  boolean isEmpty();

  void push(E e);

  E top();

  E pop();
}

public class ArrayStack<E> implements Stack<E> {
  public static final int CAPACITY = 1000;
  private E[] data;
  private int t = -1;

  public ArrayStack(int capacity) {
    data = (E[]) new Object[capacity];
  }

  public int size() {
    return (t + 1);
  }

  public boolean isEmpty() {
    return (t == -1);
  }

  public void push(E e) throws IllegalArgumentException {
    if (size() == data.length)
      throw new IllegalArgumentException("Stack is full");
    data[++t] = e;
  }

  public E top() {
    if (isEmpty())
      return null;
    return data[t];
  }

  public E pop() {
    if (isEmpty())
      return null;
    E answer = data[t];
    data[t] = null;
    t--;
    return answer;
  }
}

public class LinkedStack<E> implements Stack<E> {
  private SinglyLinkedList<E> list = new SinglyLinkedList<>();

  public int size() {
    return list.size();
  }

  public boolean isEmpty() {
    return list.isEmpty();
  }

  public void push(E element) {
    list.addFirst(element);
  }

  public E top() {
    return list.first();
  }

  public E pop() {
    return list.removeFirst();
  }

}

public static <E> void reverse(E[] a){
  Stack<E> buffer = new ArrayStack<>(a.length);
  for (int i=0; i<a.length;i++){
    buffer.push(a[i]);
  }
  for (int i=0; i<a.length;i++){
    a[i] = buffer.pop();
  }
}

public static void main(String[] args) {
  Integer[] a = {4,8,15,16,23,42};
  String[] s={"jack","kate","Hurley","Jin","Michael"};
  System.out.println("a = " + Arrays.toString(a));
  System.out.println("s = " + Arrays.toString(s));
  System.out.println("Reversing...");
  reverse(a);
  reverse(s);
  System.out.println("a = " + Arrays.toString(a));
  System.out.println("s = "+Arrays.toString(s));
}