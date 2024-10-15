package Java;

import java.util.*;

public class Graph2 {
  private List<Object> vertices;
  private List<Pair<Object, Object>> edges;

  public Graph2(Collection<Object> V, Collection<Pair<Object, Object>> E) {
    this.vertices = new ArrayList<>(V);
    this.edges = new ArrayList<>(E);
  }
}