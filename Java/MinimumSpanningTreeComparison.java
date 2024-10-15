package Java;

import java.util.*;

public class MinimumSpanningTreeComparison {
  public static void main(String[] args) {
    // Generate a random graph
    Graph randomGraph = generateRandomGraph(10, 15); // Example: 10 vertices, 15 edges

    // Perform experiments with Kruskal's algorithm
    long startTimeKruskal = System.currentTimeMillis();
    List<Pair<Object, Object>> minimumSpanningTreeKruskal = randomGraph.kruskal();
    long endTimeKruskal = System.currentTimeMillis();
    long durationKruskal = endTimeKruskal - startTimeKruskal;

    // Perform experiments with Prim-Jarnik's algorithm
    long startTimePrimJarnik = System.currentTimeMillis();
    List<Pair<Object, Object>> minimumSpanningTreePrimJarnik = randomGraph.primJarnik();
    long endTimePrimJarnik = System.currentTimeMillis();
    long durationPrimJarnik = endTimePrimJarnik - startTimePrimJarnik;

    // Output the results
    System.out.println("Kruskal's Algorithm Minimum Spanning Tree: " + minimumSpanningTreeKruskal);
    System.out.println("Prim-Jarnik's Algorithm Minimum Spanning Tree: " + minimumSpanningTreePrimJarnik);
    System.out.println("Kruskal's Algorithm Duration: " + durationKruskal + " ms");
    System.out.println("Prim-Jarnik's Algorithm Duration: " + durationPrimJarnik + " ms");
  }

  public static Graph generateRandomGraph(int numVertices, int numEdges) {
    List<Object> vertices = new ArrayList<>();
    List<Triple<Object, Object, Integer>> edges = new ArrayList<>();

    // Generate random vertices
    for (int i = 0; i < numVertices; i++) {
      vertices.add(i);
    }

    // Generate random edges with weights
    Random random = new Random();
    for (int i = 0; i < numEdges; i++) {
      int from = random.nextInt(numVertices);
      int to = random.nextInt(numVertices);
      int weight = random.nextInt(100); // Random weight between 0 and 100
      edges.add(new Triple<>(from, to, weight));
    }

    return new Graph(vertices, edges);
  }
}