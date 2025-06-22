package linkedlist;

public class RemoveNthNodeFromEndOfLinkedList {

  public static void main(String[] args) {
    int n = 2;
    ListNode head = new ListNode(4);
    head.next = new ListNode(8);
    head.next.next = new ListNode(15);
    head.next.next.next = new ListNode(16);
    head.next.next.next.next = new ListNode(23);

    ListNode resultNode = removeNthNodeOptimal(head, n);
    ListNode.printList(resultNode);
  }

  private static ListNode removeNthNodeOptimal(ListNode head, int n) {
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
}
