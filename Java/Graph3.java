import java.util.*;

public class Graph3 {
  private Map<Object, List<Object>> adjacencyList;

  public Graph3(Collection<Object> V, Collection<Pair<Object, Object>> E) {
    this.adjacencyList = new HashMap<>();

    // Initialize the adjacency list with vertices
    for (Object vertex : V) {
      this.adjacencyList.put(vertex, new ArrayList<>());
    }

    // Populate the adjacency list with edges
    for (Pair<Object, Object> edge : E) {
      Object vertex1 = edge.getFirst();
      Object vertex2 = edge.getSecond();
      this.adjacencyList.get(vertex1).add(vertex2);
      this.adjacencyList.get(vertex2).add(vertex1); // Assuming undirected graph
    }
  }
}