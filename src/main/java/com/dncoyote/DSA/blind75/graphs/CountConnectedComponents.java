package com.dncoyote.DSA.blind75.graphs;

import java.util.ArrayList;
import java.util.List;

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
        // Build the adjacency list
        List<List<Integer>> adjacencyGraph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyGraph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjacencyGraph.get(edge[0]).add(edge[1]);
            adjacencyGraph.get(edge[1]).add(edge[0]);
        }
        // Create visited array
        boolean[] visited = new boolean[n];
        int components = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, adjacencyGraph, visited);
                components++;
            }
        }
        return components;
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
