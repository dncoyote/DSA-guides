package com.dncoyote.DSA.blind75.graphs;

import java.util.ArrayList;
import java.util.List;

public class GraphValidTree {
    public static void main(String[] args) {
        // Example 1: Valid Tree
        int n1 = 5;
        int[][] edges1 = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 4 } };
        System.out.println(validTree(n1, edges1)); // Output: true

        // Example 2: Not a Tree (Cycle)
        int n2 = 5;
        int[][] edges2 = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 1, 3 }, { 1, 4 } };
        System.out.println(validTree(n2, edges2)); // Output: false

        // Example 3: Not a Tree (Disconnected)
        int n3 = 4;
        int[][] edges3 = { { 0, 1 }, { 2, 3 } };
        System.out.println(validTree(n3, edges3)); // Output: false
    }

    private static boolean validTree(int n, int[][] edges) {
        // Check edge count
        if (edges.length != n - 1) {
            return false;
        }

        // Build adjacency graph
        List<List<Integer>> adjacencyGraph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjacencyGraph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjacencyGraph.get(edge[0]).add(edge[1]);
            adjacencyGraph.get(edge[1]).add(edge[0]);
        }

        // Detect cycles
        boolean[] visited = new boolean[n];
        if (hasCycles(adjacencyGraph, 0, -1, visited)) {
            return false;
        }

        for(boolean isVisited:visited){
            if(!isVisited){
                return false;
            }
        }
        return true;

    }

    private static boolean hasCycles(List<List<Integer>> adjacencyGraph, int node, int parent, boolean[] visited) {
        visited[node] = true;

        for (int neighbor : adjacencyGraph.get(node)) {
            if (!visited[neighbor]) {
                if (hasCycles(adjacencyGraph, neighbor, node, visited)) {
                    return true;
                }
            } else if (neighbor != parent) {
                return true;
            }
        }
        return false;
    }
}
