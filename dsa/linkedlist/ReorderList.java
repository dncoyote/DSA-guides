package linkedlist;

public class ReorderList {
  public static void main(String[] args) {
    ListNode head = new ListNode(4);
    head.next = new ListNode(8);
    head.next.next = new ListNode(15);
    head.next.next.next = new ListNode(16);
    head.next.next.next.next = new ListNode(23);

    ListNode reorderedList = reorderList(head);
    printList(reorderedList);
  }

  private static void printList(ListNode head) {
    ListNode current = head;
    while (current != null) {
      System.out.println(current.val + " -> ");
      current = current.next;
    }
    System.out.println("NULL");
  }

  private static ListNode reorderList(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    ListNode current = slow;
    ListNode prev = null;
    while (current != null) {
      ListNode temp = current.next;
      current.next = prev;
      prev = current;
      current = temp;
    }

    ListNode first = head;
    ListNode second = prev;
    while (second.next != null && first != null) {
      ListNode temp1 = first.next;
      ListNode temp2 = second.next;

      first.next = second;
      second.next = temp1;

      first = temp1;
      second = temp2;
    }

    return head;
  }
}
