package com.dncoyote.DSA.blind75.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

public class Graph {
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

        printGraph(Arrays.asList(node1, node2, node3, node4));
    }

    static void printGraph(List<Node> graph) {
        for (Node node : graph) {
            System.out.print("Node " + node.val + " ->");
            for (Node neighbour : node.neighbors) {
                System.out.print(neighbour.val + " ");
            }
        }
        System.out.println();
    }

}
