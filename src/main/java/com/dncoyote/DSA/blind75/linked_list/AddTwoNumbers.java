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

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode sum = addTwoNumbersOptimal(l1, l2);
        printList(sum);
    }

    // private static ListNode addTwoNumbersBrute(ListNode l1, ListNode l2) {

    // }

    private static ListNode addTwoNumbersOptimal(ListNode l1, ListNode l2) {
        ListNode resultNode = new ListNode(Integer.MIN_VALUE);
        ListNode current = resultNode;
        int carry = 0;

        // Traverse both lists until both are exhausted
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry; // Initialize sum with the carry value

            // Add values from l1 and l2 if available
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            // Calculate new carry and the value of the current digit
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
        }

        return resultNode.next; // Return the list starting from the dummy node's next
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
