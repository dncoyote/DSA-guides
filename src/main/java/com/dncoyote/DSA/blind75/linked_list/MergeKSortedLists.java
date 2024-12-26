package com.dncoyote.DSA.blind75.linked_list;

import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class MergeKSortedLists {
    public static void main(String[] args) {
        int[][] inputLists = { { 1, 4, 5 }, { 1, 3, 4 }, { 2, 6 } };
        ListNode[] lists = new ListNode[inputLists.length];

        // Convert the array of arrays to an array of linked lists
        for (int i = 0; i < inputLists.length; i++) {
            lists[i] = arrayToLinkedList(inputLists[i]);
        }

        ListNode mergedList = mergeKSortedListsOptimal(lists);
        printList(mergedList);
    }

    private static ListNode mergeKSortedListsOptimal(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode list : lists) {
            if (list != null)
                minHeap.add(list);
        }

        ListNode resultNode = new ListNode(Integer.MIN_VALUE);
        ListNode current = resultNode;
        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            current.next = node;
            current = current.next;

            if (node.next != null) {
                minHeap.add(node.next);
            }
        }
        return resultNode.next;
    }

    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + "-");
            current = current.next;
        }
        System.out.print("null");
    }

    public static ListNode arrayToLinkedList(int[] arr) {
        ListNode head = new ListNode(0);
        ListNode current = head;
        for (int num : arr) {
            current.next = new ListNode(num);
            current = current.next;
        }
        return head.next; // Return the next node to skip the dummy node
    }
}
