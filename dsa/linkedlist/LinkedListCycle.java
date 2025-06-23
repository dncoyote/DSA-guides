package linkedlist;

import java.util.HashSet;

public class LinkedListCycle {
  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    ListNode second = new ListNode(2);
    ListNode third = new ListNode(3);
    ListNode fourth = new ListNode(4);
    ListNode fifth = new ListNode(2);

    head.next = second;
    second.next = third;
    third.next = fourth;
    fourth.next = fifth;
    // Create a loop
    // fifth.next = third;

    System.out.println(hasLinkedListCycleOptimal(head));
  }

  private static boolean hasLinkedListCycleOptimal(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;

      if (fast == slow)
        return true;
    }
    return false;
  }

  private static boolean hasLinkedListCycleBrute(ListNode head) {
    HashSet<ListNode> set = new HashSet<>();
    ListNode current = head;
    while (current != null) {
      if (set.contains(current)) {
        return true;
      }
      set.add(current);
      current = current.next;
    }
    return false;
  }
}
