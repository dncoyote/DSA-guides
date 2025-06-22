package linkedlist;

public class ListNode {
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

  public static void printList(ListNode head) {
    ListNode current = head;
    while (current != null) {
      System.out.println(current.val + " -> ");
      current = current.next;
    }
    System.out.println("NULL");
  }
}
