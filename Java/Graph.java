package Java;

import java.util.*;

public class Graph {
  private int[][] adjacencyMatrix;
  private Map<Object, Integer> vertexIndices;

  public Graph(Collection<Object> V, Collection<Pair<Object, Object>> E) {
    // Initialize vertexIndices map
    this.vertexIndices = new HashMap<>();
    int index = 0;
    for (Object vertex : V) {
      this.vertexIndices.put(vertex, index++);
    }

    // Initialize adjacencyMatrix
    int size = V.size();
    this.adjacencyMatrix = new int[size][size];
    for (Pair<Object, Object> edge : E) {
      Object vertex1 = edge.getFirst();
      Object vertex2 = edge.getSecond();
      int index1 = this.vertexIndices.get(vertex1);
      int index2 = this.vertexIndices.get(vertex2);
      this.adjacencyMatrix[index1][index2] = 1;
      this.adjacencyMatrix[index2][index1] = 1; // Assuming undirected graph
    }
  }
}