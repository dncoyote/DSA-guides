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

public class MergeTwoSortedLinkedListOptimal {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(6);
        l1.next.next.next = new ListNode(10);

        ListNode l2 = new ListNode(4);
        l2.next = new ListNode(7);
        l2.next.next = new ListNode(9);

        ListNode mergedList = mergeTwoSortedLinkedList(l1, l2);
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
            resultNode = resultNode.next;
        }

        if (l1 == null) {
            resultNode.next = l2;
        } else if (l2 == null) {
            resultNode.next = l1;
        }
        return headNode.next;
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
