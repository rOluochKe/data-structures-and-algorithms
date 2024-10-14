package Java;

public interface BinaryTree<E> extends Tree<E> {
  Position<E> left(Position<E> p) throws IllegalArgumentException;

  Position<E> right(Position<E> p) throws IllegalArgumentException;

  Position<E> sibling(Position<E> p) throws IllegalArgumentException;
}

public abstract class AbstractBinaryTree<E> extends AbstractTree<E>
    implements BinaryTree<E> {
  public Position<E> sibling(Position<E> p) {
    Position<E> parent = parent(p);
    if (parent == null)
      return null;
    if (p == left(parent))
      return right(parent);
    else
      return left(parent);
  }

  public int numChildren(Position<E> p) {
    int count = 0;
    if (left(p) != null)
      count++;
    if (right(p) != null)
      count++;
    return count;
  }

  public Iterable<Position<E>> children(Position<E> p) {
    List<Position<E>> snapshot = new ArrayList<>(2);
    if (left(p) != null)
      snapshot.add(left(p));
    if (right(p) != null)
      snapshot.add(right(p));
    return snapshot;
  }
}