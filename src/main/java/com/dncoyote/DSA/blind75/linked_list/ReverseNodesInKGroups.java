package com.dncoyote.DSA.blind75.linked_list;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class ReverseNodesInKGroups {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int k = 3;

        printList(head);
        ListNode result = reverseKGroupOptimal(head, k);
        System.out.println("\n ");
        System.out.println("Reversed : ");
        printList(result);
    }

    private static ListNode reverseKGroupOptimal(ListNode head, int k) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy;

        while (true) {
            ListNode kthNode = getKthNode(prevGroupEnd, k);

            if (kthNode == null)
                break;

            ListNode start = prevGroupEnd.next;
            ListNode end = kthNode.next;

            reverseGroup(start, kthNode);

            prevGroupEnd.next = kthNode;
            start.next = end;

            prevGroupEnd = start;
        }
        return dummy.next;
    }

    private static void reverseGroup(ListNode start, ListNode end) {
        ListNode current = start;
        ListNode prev = null;

        while (prev != end) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
    }

    private static ListNode getKthNode(ListNode current, int k) {
        while (current != null && k > 0) {
            current = current.next;
            k--;
        }
        return current;
    }

    private static ListNode reverseKGroupBrute(ListNode head, int k) {
        if (head == null)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevGroupEnd = dummy;

        // Count the total number of nodes
        int totalNodes = 0;
        ListNode current = head;
        while (current != null) {
            totalNodes++;
            current = current.next;
        }

        while (totalNodes >= k) {
            // first node of the current k-sized group
            ListNode start = prevGroupEnd.next;
            // last node of the current k-sized group
            ListNode end = start;
            for (int i = 1; i < k; i++) {
                end = end.next;
            }

            // next k sized group
            ListNode nextGroup = end.next;
            // temporarily disconnects current group and rest of the list for string
            // reversal
            end.next = null;
            reverseLinkedList(start);

            prevGroupEnd.next = end;
            start.next = nextGroup;
            prevGroupEnd = start;

            totalNodes -= k;
        }
        return dummy.next;
    }

    private static void reverseLinkedList(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        while (current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
    }

    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + "-");
            current = current.next;
        }
        System.out.print("null");
    }
}
