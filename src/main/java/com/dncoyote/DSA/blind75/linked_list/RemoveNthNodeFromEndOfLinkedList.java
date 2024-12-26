package com.dncoyote.DSA.blind75.linked_list;

import java.util.ArrayList;
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

public class RemoveNthNodeFromEndOfLinkedList {
    public static void main(String[] args) {
        int n = 2;
        ListNode head = new ListNode(4);
        head.next = new ListNode(8);
        head.next.next = new ListNode(15);
        head.next.next.next = new ListNode(16);
        head.next.next.next.next = new ListNode(23);

        RemoveNthNodeFromEndOfLinkedList obj = new RemoveNthNodeFromEndOfLinkedList();
        ListNode resultNode = obj.removeNthNodeOptimal(head, n);
        obj.printList(resultNode);
    }

    ListNode removeNthNodeOptimal(ListNode head, int n) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;

        ListNode ptr1 = dummy;
        ListNode ptr2 = dummy;

        // Advance the second pointer by n + 1 steps
        for (int i = 0; i <= n; i++) {
            ptr2 = ptr2.next;
        }

        // Move both pointers until second pointer reaches the end
        while (ptr2 != null) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        // Remove the nth node
        ptr1.next = ptr1.next.next;
        return dummy.next;
    }

    private ListNode removeNthNodeBrute(ListNode head, int n) {
        List<Integer> values = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            values.add(current.val);
            current = current.next;
        }
        int position = values.size() - n;
        values.remove(position);

        ListNode resultNode = new ListNode(Integer.MIN_VALUE);
        ListNode headNode = resultNode;
        for (int val : values) {
            resultNode.next = new ListNode(val);
            resultNode = resultNode.next;
        }
        return headNode.next;

    }

    void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + "->");
            current = current.next;
        }
        System.out.print("null");
    }
}
