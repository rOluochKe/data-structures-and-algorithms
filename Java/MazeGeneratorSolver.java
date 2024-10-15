package Java;

import java.util.*;

public class MazeGeneratorSolver {
  public static void main(String[] args) {
    int n = 5; // Example grid size
    Graph dualGraph = generateDualGraph(n);
    List<Pair<Pair<Object, Object>, Integer>> minimumSpanningTree = dualGraph.kruskal();
    Set<Pair<Integer, Integer>> removedWalls = new HashSet<>();

    for (Pair<Pair<Object, Object>, Integer> edge : minimumSpanningTree) {
      Pair<Object, Object> vertices = edge.getFirst();
      int weight = edge.getSecond();
      Pair<Integer, Integer> wall = getWallFromVertices(vertices);
      removedWalls.add(wall);
    }

    // Draw the maze with removed walls

    // Solve the maze

    // Visualize the solution
  }

  public static Graph generateDualGraph(int n) {
    List<Object> vertices = new ArrayList<>();
    List<Triple<Object, Object, Integer>> edges = new ArrayList<>();

    // Generate vertices for each cell in the grid
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        vertices.add(new Pair<>(i, j));
      }
    }

    // Generate edges based on shared walls
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (i < n - 1) {
          edges.add(new Triple<>(new Pair<>(i, j), new Pair<>(i + 1, j), new Random().nextInt(100)));
        }
        if (j < n - 1) {
          edges.add(new Triple<>(new Pair<>(i, j), new Pair<>(i, j + 1), new Random().nextInt(100)));
        }
      }
    }

    return new Graph(vertices, edges);
  }

  public static Pair<Integer, Integer> getWallFromVertices(Pair<Object, Object> vertices) {
    int x1 = (int) vertices.getFirst();
    int y1 = (int) vertices.getSecond();
    int x2 = (int) vertices.getFirst();
    int y2 = (int) vertices.getSecond();

    if (x1 == x2) {
      return new Pair<>(x1, Math.min(y1, y2));
    } else {
      return new Pair<>(Math.min(x1, x2), y1);
    }
  }
}