package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphValidTree {

  public static void main(String[] args) {
    int n1 = 5;
    int[][] edges1 = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 4 } };
    System.out.println(validTreeBFS(n1, edges1)); // true

    int n2 = 5;
    int[][] edges2 = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 1, 3 }, { 1, 4 } };
    System.out.println(validTreeBFS(n2, edges2)); // false

    int n3 = 4;
    int[][] edges3 = { { 0, 1 }, { 2, 3 } };
    System.out.println(validTreeBFS(n3, edges3)); // false
  }

  private static boolean validTreeBFS(int nodes, int[][] edges) {
    if (edges.length != nodes - 1) {
      return false;
    }

    List<List<Integer>> adjacencyGraph = new ArrayList<>();
    for (int i = 0; i < nodes; i++) {
      adjacencyGraph.add(new ArrayList<>());
    }

    for (int[] edge : edges) {
      adjacencyGraph.get(edge[0]).add(edge[1]);
      adjacencyGraph.get(edge[1]).add(edge[0]);
    }

    boolean[] visited = new boolean[nodes];
    Queue<Integer> queue = new LinkedList<>();
    queue.add(0);
    visited[0] = true;

    while (!queue.isEmpty()) {
      int node = queue.poll();
      for (int neighbor : adjacencyGraph.get(node)) {
        if (!visited[neighbor]) {
          visited[neighbor] = true;
          queue.offer(neighbor);
        }
      }
    }

    for (boolean flag : visited) {
      if (!flag)
        return false;
    }

    return true;
  }
}
