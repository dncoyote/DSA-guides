package com.dncoyote.DSA.blind75.linked_list;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class ReorderLinkedListOptimal {
    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(8);
        head.next.next = new ListNode(15);
        head.next.next.next = new ListNode(16);
        head.next.next.next.next = new ListNode(23);

        ReorderLinkedListOptimal ob = new ReorderLinkedListOptimal();
        ListNode reorderedList = ob.reorderList(head);
        ob.printList(reorderedList);

    }

    void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + "->");
            current = current.next;
        }
        System.out.print("null");
    }

    ListNode reorderList(ListNode head) {
        // Find the middle of the List
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half of list
        ListNode prev = null;
        ListNode current = slow;
        while (current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }

        // reorder
        ListNode first = head;
        ListNode second = prev; // The head of the reversed second half
        while (second.next != null && first != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second; // Link from first half to second half
            second.next = temp1; // Link from second half to first half

            first = temp1; // Move forward in the first half
            second = temp2; // Move forward in the second half
        }
        return head;
    }
}
