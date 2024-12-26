package com.dncoyote.DSA.blind75.linked_list;

import java.util.ArrayList;

class Node {
    int val;
    Node next;
    Node random;

    Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyListWithRandomPointer {
    public static void main(String[] args) {
        int[][] input = {
                { 7, -1 },
                { 13, 0 },
                { 11, 4 },
                { 10, 2 },
                { 1, 0 }
        };

        Node head = createLinkedList(input);
        System.out.println("OriginalList - ");
        printList(head);
        Node copy = copyRandomList(head);
        System.out.println("CopyList - ");
        printList(copy);
    }

    public static Node copyRandomList(Node head) {
        if (head == null)
            return null;

        // Interleave the original list with its copy
        Node current = head;
        while (current != null) {
            Node copy = new Node(current.val);
            copy.next = current.next;
            current.next = copy;
            current = copy.next;
        }

        // Assign random pointers for the copies
        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }

        // Restore the original list and separate the copied list
        Node original = head;
        Node copyHead = head.next;
        Node copy = copyHead;
        while (original != null) {
            original.next = original.next.next;
            if (copy.next != null) {
                copy.next = copy.next.next;
            }
            original = original.next;
            copy = copy.next;
        }
        return copyHead;
    }

    public static Node createLinkedList(int[][] data) {
        if (data == null || data.length == 0)
            return null;

        // Step 1: Create all nodes and store them in a list for random pointer access
        ArrayList<Node> nodes = new ArrayList<>();
        for (int[] pair : data) {
            nodes.add(new Node(pair[0]));
        }

        // Step 2: Set next pointers
        for (int i = 0; i < nodes.size() - 1; i++) {
            nodes.get(i).next = nodes.get(i + 1);
        }

        // Step 3: Set random pointers
        for (int i = 0; i < data.length; i++) {
            int randomIndex = data[i][1];
            nodes.get(i).random = randomIndex != -1 ? nodes.get(randomIndex) : null;
        }

        // Return the head of the list
        return nodes.get(0);
    }

    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print("[" + current.val + ", ");
            System.out.print(current.random != null ? current.random.val : "null");
            System.out.print("] -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
