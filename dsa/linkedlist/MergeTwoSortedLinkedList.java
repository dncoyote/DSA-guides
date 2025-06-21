package linkedlist;

public class MergeTwoSortedLinkedList {

  public static void main(String[] args) {
    ListNode l1 = new ListNode(1);
    l1.next = new ListNode(3);
    l1.next.next = new ListNode(6);
    l1.next.next.next = new ListNode(10);

    ListNode l2 = new ListNode(4);
    l2.next = new ListNode(7);
    l2.next.next = new ListNode(9);

    ListNode mergedList = mergeTwoSortedLinkedListOptimal(l1, l2);
    printLinkedList(mergedList);
  }

  private static void printLinkedList(ListNode mergedList) {
    ListNode current = mergedList;
    while (current!=null) {
      System.out.println(current.val+ "->");
      current = current.next;
    }
    System.out.println("null");
  }

  private static ListNode mergeTwoSortedLinkedListOptimal(ListNode l1, ListNode l2) {
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


}
