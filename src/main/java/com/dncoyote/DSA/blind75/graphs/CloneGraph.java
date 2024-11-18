package com.dncoyote.DSA.blind75.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Node {
    int val;
    List<Node> neighbors;

    Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    Node(int val) {
        this.val = val;
        neighbors = new ArrayList<>();
    }

    Node(int val, List<Node> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }
}

public class CloneGraph {
    public static void main(String[] args) {
        Node node1 = new Node(11);
        Node node2 = new Node(22);
        Node node3 = new Node(33);
        Node node4 = new Node(44);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node3);
        node4.neighbors.add(node1);

        Node cloneGraph = cloneGraph(node1);
        System.out.println("Cloned graph node value: " + cloneGraph.val);
    }

    private static Node cloneGraph(Node node) {
        if (node == null)
            return null;

        Map<Node, Node> visited = new HashMap<>();

        return dfs(node, visited);
    }

    private static Node dfs(Node node, Map<Node, Node> visited) {
        if (visited.containsKey(node))
            return visited.get(node);

        Node clone = new Node(node.val);
        visited.put(node, clone);

        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(dfs(neighbor, visited));
        }

        return clone;
    }
}
