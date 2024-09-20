package com.dncoyote.DSA.blind75.linked_list;

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

        for (int i = 0; i <= n; i++) {
            ptr2 = ptr2.next;
        }

        while (ptr2 != null) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        ptr1.next = ptr1.next.next;
        return dummy.next;
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
