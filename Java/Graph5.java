import java.util.*;

public class Graph5 {
  private Map<Object, List<Pair<Object, Integer>>> adjacencyList;

  public Graph5(Collection<Object> V, Collection<Triple<Object, Object, Integer>> E) {
    this.adjacencyList = new HashMap<>();

    // Initialize the adjacency list with vertices
    for (Object vertex : V) {
      this.adjacencyList.put(vertex, new ArrayList<>());
    }

    // Populate the adjacency list with edges and weights
    for (Triple<Object, Object, Integer> edge : E) {
      Object vertex1 = edge.getFirst();
      Object vertex2 = edge.getSecond();
      int weight = edge.getThird();
      this.adjacencyList.get(vertex1).add(new Pair<>(vertex2, weight));
      this.adjacencyList.get(vertex2).add(new Pair<>(vertex1, weight)); // Assuming undirected graph
    }
  }

  public List<Pair<Object, Object>> primJarnik() {
    Set<Object> visited = new HashSet<>();
    PriorityQueue<Triple<Object, Object, Integer>> priorityQueue = new PriorityQueue<>(
        Comparator.comparingInt(Triple::getThird));
    List<Pair<Object, Object>> minimumSpanningTree = new ArrayList<>();

    Object startVertex = adjacencyList.keySet().iterator().next();
    visited.add(startVertex);

    for (Pair<Object, Integer> neighbor : adjacencyList.get(startVertex)) {
      priorityQueue.offer(new Triple<>(startVertex, neighbor.getFirst(), neighbor.getSecond()));
    }

    while (!priorityQueue.isEmpty() && visited.size() < adjacencyList.size()) {
      Triple<Object, Object, Integer> edge = priorityQueue.poll();
      Object from = edge.getFirst();
      Object to = edge.getSecond();
      int weight = edge.getThird();

      if (visited.contains(from) && visited.contains(to)) {
        continue;
      }

      minimumSpanningTree.add(new Pair<>(from, to));
      visited.add(visited.contains(from) ? to : from);

      for (Pair<Object, Integer> neighbor : adjacencyList.get(visited.contains(from) ? to : from)) {
        if (!visited.contains(neighbor.getFirst())) {
          priorityQueue
              .offer(new Triple<>(visited.contains(from) ? to : from, neighbor.getFirst(), neighbor.getSecond()));
        }
      }
    }

    return minimumSpanningTree;
  }
}