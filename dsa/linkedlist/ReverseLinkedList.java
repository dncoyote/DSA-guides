package linkedlist;

public class ReverseLinkedList {
  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);

    System.out.println("Linked List before reversing:");
    printList(head);
    ListNode reverseList = reverseList(head);
    System.out.println("Linked List after reversing:");
    printList(reverseList);
  }

  private static ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode current = head;
    while (current != null) {
      ListNode temp = current.next;
      current.next = prev;
      prev = current;
      current = temp;
    }
    return prev;
  }

  private static void printList(ListNode head) {
    ListNode current = head;
    while (current != null) {
      System.out.print(current.val + " -> ");
      current = current.next;
    }
    System.out.println("NULL");
  }
}
