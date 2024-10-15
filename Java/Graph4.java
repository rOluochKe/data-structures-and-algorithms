import java.util.*;

public class Graph4 {
  private Map<Object, List<Object>> adjacencyList;

  public Graph4(Collection<Object> V, Collection<Pair<Object, Object>> E) {
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
    }
  }

  public boolean isReachable(Object source, Object target) {
    Set<Object> visited = new HashSet<>();
    return dfs(source, target, visited);
  }

  private boolean dfs(Object current, Object target, Set<Object> visited) {
    if (current.equals(target)) {
      return true;
    }

    visited.add(current);
    for (Object neighbor : adjacencyList.get(current)) {
      if (!visited.contains(neighbor)) {
        if (dfs(neighbor, target, visited)) {
          return true;
        }
      }
    }

    return false;
  }

  public boolean[][] transitiveClosureFloydWarshall() {
    int size = adjacencyList.size();
    boolean[][] transitiveClosure = new boolean[size][size];

    // Initialize transitive closure matrix based on graph's adjacency list

    // Floyd-Warshall algorithm to compute transitive closure

    return transitiveClosure;
  }
}