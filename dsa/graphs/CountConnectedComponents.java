package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CountConnectedComponents {

  public static void main(String[] args) {
    int n1 = 5;
    int[][] edges1 = { { 0, 1 }, { 1, 2 }, { 3, 4 } };
    System.out.println(countComponents(n1, edges1)); // Output: 2

    int n2 = 4;
    int[][] edges2 = { { 0, 1 }, { 2, 3 } };
    System.out.println(countComponents(n2, edges2)); // Output: 2

    int n3 = 6;
    int[][] edges3 = { { 0, 1 }, { 0, 2 }, { 3, 4 }, { 4, 5 } };
    System.out.println(countComponents(n3, edges3)); // Output: 2

    int n4 = 3;
    int[][] edges4 = { { 0, 1 }, { 0, 2 } };
    System.out.println(countComponents(n4, edges4)); // Output: 1
  }

  private static int countComponents(int n, int[][] edges) {
    List<List<Integer>> adjacencyGraph = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      adjacencyGraph.add(new ArrayList<>());
    }

    for (int[] edge : edges) {
      adjacencyGraph.get(edge[0]).add(edge[1]);
      adjacencyGraph.get(edge[1]).add(edge[0]);
    }

    boolean[] visited = new boolean[n];
    visited[0] = false;
    int count = 0;

    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        count++;
        dfs(i, adjacencyGraph, visited);
        // bfs(i, adjacencyGraph, visited);
      }
    }
    return count;
  }

  private static void bfs(int start, List<List<Integer>> adjacencyGraph, boolean[] visited) {
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(start);
    visited[start] = true;

    while (!queue.isEmpty()) {
      int node = queue.poll();
      for (int neighbor : adjacencyGraph.get(node)) {
        if (!visited[neighbor]) {
          visited[neighbor] = true;
          queue.add(neighbor);
        }
      }
    }
  }

  private static void dfs(int node, List<List<Integer>> adjacencyGraph, boolean[] visited) {
    visited[node] = true;
    for (int neighbor : adjacencyGraph.get(node)) {
      if (!visited[neighbor]) {
        dfs(neighbor, adjacencyGraph, visited);
      }
    }
  }

}
