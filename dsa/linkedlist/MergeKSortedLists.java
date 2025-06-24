package linkedlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {
  public static void main(String[] args) {
    int[][] inputLists = { { 1, 4, 5 }, { 1, 3, 4 }, { 2, 6 } };
    ListNode[] lists = new ListNode[inputLists.length];

    // Convert the array of arrays to an array of linked lists
    for (int i = 0; i < inputLists.length; i++) {
      lists[i] = arrayToLinkedList(inputLists[i]);
    }

    ListNode mergedList = mergeKSortedListsOptimal(lists);
    ListNode.printList(mergedList);
  }

  private static ListNode mergeKSortedListsOptimal(ListNode[] lists) {
    PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

    for (ListNode node : lists) {
      if (node != null) {
        minHeap.offer(node);
      }
    }

    ListNode dummy = new ListNode(0);
    ListNode current = dummy;
    while (!minHeap.isEmpty()) {
      ListNode smallest = minHeap.poll();
      current.next = smallest;
      current = current.next;

      if (null != smallest.next) {
        minHeap.offer(smallest.next);
      }
    }
    return dummy.next;
  }

  private static ListNode mergeKSortedListsBrute(ListNode[] lists) {
    List<Integer> list = new ArrayList<>();

    for (ListNode node : lists) {
      while (node != null) {
        list.add(node.val);
        node = node.next;
      }
    }
    Collections.sort(list);

    ListNode dummy = new ListNode(0);
    ListNode current = dummy;
    for (Integer num : list) {
      current.next = new ListNode(num);
      current = current.next;
    }
    return dummy.next;
  }

  public static ListNode arrayToLinkedList(int[] arr) {
    ListNode head = new ListNode(0);
    ListNode current = head;
    for (int num : arr) {
      current.next = new ListNode(num);
      current = current.next;
    }
    return head.next; // Return the next node to skip the dummy node
  }
}
