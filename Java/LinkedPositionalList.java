package Java;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedPositionalList<E> implements PositionalList<E> {

  // Nested Node class
  private static class Node<E> implements Position<E> {
    private E element;
    private Node<E> prev;
    private Node<E> next;

    public Node(E e, Node<E> p, Node<E> n) {
      element = e;
      prev = p;
      next = n;
    }

    @Override
    public E getElement() throws IllegalStateException {
      if (next == null) {
        throw new IllegalStateException("Position is no longer valid");
      }
      return element;
    }

    public void setElement(E e) {
      element = e;
    }

    public Node<E> getPrev() {
      return prev;
    }

    public Node<E> getNext() {
      return next;
    }

    public void setPrev(Node<E> p) {
      prev = p;
    }

    public void setNext(Node<E> n) {
      next = n;
    }
  }

  // Private fields of LinkedPositionalList
  private Node<E> header;
  private Node<E> trailer;
  private int size = 0;

  // Constructor
  public LinkedPositionalList() {
    header = new Node<>(null, null, null);
    trailer = new Node<>(null, header, null);
    header.setNext(trailer);
  }

  // Private utility
  private Node<E> validate(Position<E> p) throws IllegalArgumentException {
    if (!(p instanceof Node)) {
      throw new IllegalArgumentException("Invalid position");
    }
    Node<E> node = (Node<E>) p;
    if (node.getNext() == null) {
      throw new IllegalArgumentException("Invalid position");
    }
    return node;
  }

  // Public accessor methods
  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public Position<E> first() {
    return header.getNext();
  }

  public Position<E> last() {
    return trailer.getPrev();
  }

  public Position<E> before(Position<E> p) throws IllegalArgumentException {
    Node<E> node = validate(p);
    return node.getPrev();
  }

  public Position<E> after(Position<E> p) throws IllegalArgumentException {
    Node<E> node = validate(p);
    return node.getNext();
  }

  // Private utilities
  private Position<E> addBetween(E e, Node<E> pred, Node<E> succ) {
    Node<E> newNode = new Node<>(e, pred, succ);
    pred.setNext(newNode);
    succ.setPrev(newNode);
    size++;
    return newNode;
  }

  private Position<E> position(Node<E> node) {
    if (node == header || node == trailer) {
      return null;
    }
    return node;
  }

  // Public update methods
  public Position<E> addFirst(E e) {
    return addBetween(e, header, header.getNext());
  }

  public Position<E> addLast(E e) {
    return addBetween(e, trailer.getPrev(), trailer);
  }

  public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException {
    Node<E> node = validate(p);
    return addBetween(e, node.getPrev(), node);
  }

  public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException {
    Node<E> node = validate(p);
    return addBetween(e, node, node.getNext());
  }

  public E set(Position<E> p, E e) throws IllegalArgumentException {
    Node<E> node = validate(p);
    E oldElement = node.getElement();
    node.setElement(e);
    return oldElement;
  }

  public E remove(Position<E> p) throws IllegalArgumentException {
    Node<E> node = validate(p);
    Node<E> predecessor = node.getPrev();
    Node<E> successor = node.getNext();
    predecessor.setNext(successor);
    successor.setPrev(predecessor);
    size--;
    E element = node.getElement();
    node.setNext(null);
    node.setPrev(null);
    return element;
  }

  private class PositionIterator implements Iterator<Position<E>> {
    private Position<E> cursor = first();
    private Position<E> recent = null;

    public boolean hasNext() {
      return cursor != null;
    }

    public Position<E> next() throws NoSuchElementException {
      if (cursor == null) {
        throw new NoSuchElementException("No next element");
      }
      recent = cursor;
      cursor = after(cursor);
      return recent;
    }

    public void remove() throws UnsupportedOperationException {
      throw new UnsupportedOperationException("remove not supported");
    }
  }

  private class PositionIterable implements Iterable<Position<E>> {
    public Iterator<Position<E>> iterator() {
      return new PositionIterator();
    }
  }

  public Iterable<Position<E>> positions() {
        return new PositionIterable();
    }
