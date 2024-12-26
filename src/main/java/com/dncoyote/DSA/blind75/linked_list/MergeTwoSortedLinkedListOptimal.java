package com.dncoyote.DSA.blind75.linked_list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

public class MergeTwoSortedLinkedListOptimal {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(6);
        l1.next.next.next = new ListNode(10);

        ListNode l2 = new ListNode(4);
        l2.next = new ListNode(7);
        l2.next.next = new ListNode(9);

        ListNode mergedList = mergeTwoSortedLinkedListBrute(l1, l2);
        printLinkedList(mergedList);
    }

    public static ListNode mergeTwoSortedLinkedList(ListNode l1, ListNode l2) {
        ListNode resultNode = new ListNode(Integer.MIN_VALUE);
        ListNode headNode = resultNode;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                resultNode.next = l1;
                l1 = l1.next;
            } else {
                resultNode.next = l2;
                l2 = l2.next;
            }
            resultNode = resultNode.next; // Move resultNode forward to continue building the merged list.
        }

        if (l1 == null) {
            resultNode.next = l2; // Attach remaining l2 nodes
        } else if (l2 == null) {
            resultNode.next = l1; // Attach remaining l1 nodes
        }
        return headNode.next; // skips the dummy node
    }

    public static ListNode mergeTwoSortedLinkedListBrute(ListNode l1, ListNode l2) {
        List<Integer> values = new ArrayList<>();

        while (l1 != null) {
            values.add(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            values.add(l2.val);
            l2 = l2.next;
        }

        Collections.sort(values);
        ListNode resultNode = new ListNode(Integer.MIN_VALUE);
        ListNode headNode = resultNode;
        for (int val : values) {
            resultNode.next = new ListNode(val);
            resultNode = resultNode.next;
        }
        return headNode.next; // skips the dummy node
    }

    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + "->");
            current = current.next;
        }
        System.out.print("null");
    }
}
