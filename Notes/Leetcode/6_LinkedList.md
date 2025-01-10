# **Linked List**
## **Theory**

#### What is a Linked List
- In Array, values are stored in contiguous memory locations. Array is easy to traverse, but we cannot increase or decrease size.
- This is where a Linked List comes into the picture.
- Linked List is not stored in contiguous memory locations. They are stored in heap memory and their size can be increased and decreased anytime.
- With every data, the `next` value is stored.
- Starting point of Linked List is called as `head`.
- The `next` value of the last element(also called as `tail`)  is `null`.
- When a new value is to be stored
    - Add the value somewhere in the heap.
    - Update the `next` value of last element to the location of the new value.

#### Where is it used?
- In Data Structures, Linked List is used in Stacks and Queue.
- In real life, we use it in browser.

#### Struct/Class in C++ Java
```c++
int x =2;
int* y = &x;
cout<<y;
```
- Creates `x` somewhere in the heap memory and stores 2.
- Stores the memory location of `x` in `y`.

## **Reverse Linked List**
<div align="center">
  <img alt="image" src="assets/Screenshot 2024-12-25 164550.png" />
</div>

#### Optimal 

```java
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

public class ReverseLinkedListOptimal {
    public void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("NULL");
    }

    public ListNode reverseList(ListNode head) {
        // Initialize pointers
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextTemp = current.next; // Store next node
            current.next = prev; // Reverse the link
            prev = current; // Move prev forward
            current = nextTemp; // Move current forward
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original List:");
        ReverseLinkedListOptimal solution = new ReverseLinkedListOptimal();
        solution.printList(head);

        ListNode reversedHead = solution.reverseList(head);
        System.out.println("Reversed List:");
        solution.printList(reversedHead);
    }
}
```
>Time Complexity - O(n)
- n is number of nodes in the LinkedList.

>Space Complexity - O(1)
#### Explanation

-

#### Steps

-

## **Merge Two sorted Linked List**
<div align="center">
  <img alt="image" src="assets/Screenshot 2024-12-26 105529.png" />
</div>

#### Brute - 

```java
public static ListNode mergeTwoSortedLinkedListBrute(ListNode l1, ListNode l2) {
        List<Integer> values = new ArrayList<>();

        while (l1 != null) {
            values.add(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            values.add(l2.val);
            l2 = l2.next;
        }

        Collections.sort(values);
        ListNode resultNode = new ListNode(Integer.MIN_VALUE);
        ListNode headNode = resultNode;
        for (int val : values) {
            resultNode.next = new ListNode(val);
            resultNode = resultNode.next;
        }
        return headNode.next; // skips the dummy node
    }
```
>Time Complexity -O(m + n + (m + n) * log(m + n)) - O((m + n) * log(m + n))
- O(m + n) - Collecting and adding values to list.
- O(m + n) * log(m + n) - Sorting
- m is size of l1.
- n is size of l2. 
>Space Complexity - O(m)+O(n)
- m is size of l1.
- n is size of l2. 

#### Steps
- Take 1st Linked list and store to array using while loop
- Take 2nd Linked List and store to same array using while loop.
- call Array.sort to sort.
- Convert array to Linked List

#### Optimal -
```java
public static ListNode mergeTwoSortedLinkedList(ListNode l1, ListNode l2) {
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
            resultNode = resultNode.next; // Move resultNode forward to continue building the merged list.
        }

        if (l1 == null) {
            resultNode.next = l2; // Attach remaining l2 nodes
        } else if (l2 == null) {
            resultNode.next = l1; // Attach remaining l1 nodes
        }
        return headNode.next; // skips the dummy node
    }
```
>Time Complexity - O(m+n)
- m is size of l1.
- n is size of l2. 

>Space Complexity - O(1)

#### Explanation
- `ListNode resultNode = new ListNode(Integer.MIN_VALUE);` - This is the dummy node. Using a dummy node simplifies the merging process because it eliminates the need for special handling of the head node. Without it, you'd need additional checks to initialize the head separately, which makes the code more complex.
- `resultNode` 
    - It is for Initialization of the linked list.
    - A dummy node (resultNode) is created to act as the starting point of the merged list.
    - Integer.MIN_VALUE is used as a placeholder value since the dummy node's value doesn't matter; it's just a temporary marker to make merging easier.
- `headNode`
    - It is for Keeping track of the head.
    - headNode is assigned the reference of resultNode.
    - As the merging progresses, resultNode keeps moving forward (i.e., pointing to new nodes).
    - However, headNode always points to the dummy node, which ensures we can later return the head of the actual merged list.
- `resultNode = resultNode.next` - If we don’t update `resultNode` to `resultNode.next`, the pointer will remain stuck on the same node. This will overwrite the next field of the same node repeatedly, and the list will not grow correctly.

## **Reorder Linked List**
<div align="center">
  <img alt="image" src="assets/Screenshot 2024-12-26 112821.png" />
</div>

#### Brute - 

```java

```
>Time Complexity - O(n)

>Space Complexity - O(n)
#### Explanation

- Convert Linked List to array.
- Add pointer on the beginning and at the end.

#### Steps

-

#### Optimal -

```java
ListNode reorderList(ListNode head) {
        // Find the middle of the List
        ListNode slow = head;
        ListNode fast = head;
        // Tortoise and Hare Algorithm
        // Floyd's Cycle Detection Algorithm
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
```
>Time Complexity - O(n)

>Space Complexity - O(1)
#### Explanation

-

#### Steps

-

## **Remove nth Node from End of Linked List**
<div align="center">
  <img alt="image" src="assets/Screenshot 2024-12-26 123723.png" />
</div>

#### Brute - 

```java
private ListNode removeNthNodeBrute(ListNode head, int n) {
        List<Integer> values = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            values.add(current.val);
            current = current.next;
        }
        int position = values.size() - n;
        values.remove(position);

        ListNode resultNode = new ListNode(Integer.MIN_VALUE);
        ListNode headNode = resultNode;
        for (int val : values) {
            resultNode.next = new ListNode(val);
            resultNode = resultNode.next;
        }
        return headNode.next;

    }
```
>Time Complexity - O(n)+O(n)+O(n) - O(3n) - O(n)
- O(n) for adding to list
- O(n) for removing nth position from end.
- O(n) for creating a new LinkedList.

>Space Complexity - O(n)
#### Explanation

-

#### Optimal -
```java
public class RemoveNthNodeFromEndOfLinkedList {
    public static void main(String[] args) {
        int n = 2;
        ListNode head = new ListNode(4);
        head.next = new ListNode(8);
        head.next.next = new ListNode(15);
        head.next.next.next = new ListNode(16);
        head.next.next.next.next = new ListNode(23);

        RemoveNthNodeFromEndOfLinkedList obj = new RemoveNthNodeFromEndOfLinkedList();
        ListNode resultNode = obj.removeNthNodeOptimal(head, n);
        obj.printList(resultNode);
    }

   ListNode removeNthNodeOptimal(ListNode head, int n) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;

        ListNode ptr1 = dummy;
        ListNode ptr2 = dummy;

        // Advance the second pointer by n + 1 steps
        for (int i = 0; i <= n; i++) {
            ptr2 = ptr2.next;
        }

        // Move both pointers until second pointer reaches the end
        while (ptr2 != null) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        // Remove the nth node
        ptr1.next = ptr1.next.next;
        return dummy.next;
    }
}
```
>Time Complexity - O(n)

>Space Complexity - O(1)

#### Explanation

-

#### Steps

-

## **Linked List Cycle**
<div align="center">
  <img alt="image" src="assets/Screenshot 2024-12-26 125708.png" />
</div>

#### Brute - 

```java
boolean hasLinkedListCycleBrute(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode current = head;
        while (current != null) {
            if (set.contains(current))
                return true;
            set.add(current);
            current = current.next;
        }
        return false;
    }
```
>Time Complexity - O(n)

>Space Complexity - O(n)
#### Explanation

- Using hash set.


#### Optimal -

```java
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
        fifth.next = third;

        LinkedListCycle obj = new LinkedListCycle();
        System.out.println(obj.hasLinkedListCycle(head));
    }

    boolean hasLinkedListCycle(ListNode head) {
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
}
```
>Time Complexity - O(n)

>Space Complexity - O(1)
#### Explanation

-

## **Merge K Sorted Lists**
<div align="center">
  <img alt="image" src="assets/Screenshot 2024-12-26 135453.png" />
</div>

#### Brute -

```java
private static ListNode mergeKSortedListsBrute(ListNode[] lists) {
        List<Integer> values = new ArrayList<>();
        for (ListNode list : lists) {
            while (list != null) {
                values.add(list.val);
                list = list.next;
            }
        }

        Collections.sort(values);

        ListNode result = new ListNode(0);
        ListNode current = result;
        for (int value : values) {
            current.next = new ListNode(value);
            current = current.next;
        }

        return result.next;
    }
```
>Time Complexity - O(n log n)
- n is the total number of nodes across all lists
>Space Complexity - O(n)
#### Explanation

-

#### Steps

-

#### Optimal - 

```java
public class MergeKSortedLists {
    public static void main(String[] args) {
        int[][] inputLists = { { 1, 4, 5 }, { 1, 3, 4 }, { 2, 6 } };
        ListNode[] lists = new ListNode[inputLists.length];

        // Convert the array of arrays to an array of linked lists
        for (int i = 0; i < inputLists.length; i++) {
            lists[i] = arrayToLinkedList(inputLists[i]);
        }

        ListNode mergedList = mergeKSortedListsOptimal(lists);
        printList(mergedList);
    }

    private static ListNode mergeKSortedListsOptimal(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // add the first node of each linked list into the min-heap
        for (ListNode list : lists) {
            if (list != null)
                minHeap.add(list);
        }

        ListNode resultNode = new ListNode(Integer.MIN_VALUE);
        ListNode current = resultNode;
        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            current.next = node;
            current = current.next;

            if (node.next != null) {
                minHeap.add(node.next);
            }
        }
        return resultNode.next;
    }

    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + "-");
            current = current.next;
        }
        System.out.print("null");
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
```
>Time Complexity - O(n log k)
- n is the total number of elements across all lists
- k is the numbder of lists.

>Space Complexity - O(k)
- k is the number of lists, because we are storing up to k nodes in the heap at any point in time
#### Explanation

- `for (ListNode list : lists)`
    - we need to add the first node of each linked list into the min-heap so we can start comparing them to figure out which one has the smallest node.
    - After this loop, the min-heap will contain [`1`(from list1),`1`(from list2),`2`(from list3)]
- `if (node.next != null) { minHeap.add(node.next);`
    - At this point in the loop, `minHeap.poll()` has removed the smallest node from the min-heap (the node with the smallest value among all the current nodes in the heap). This node is assigned to `node` and is added to the Linked List.
    - Now we need to check whether node itself has a next node. If `node.next != null`, it means node isn't the last node in its original linked list. Therefore, it still has another node that we need to process.
#### Steps

-

#### Follow up 

-

## **Copy List with Random Pointer**
<div align="center">
  <img alt="image" src="assets/Screenshot 2024-12-26 160254.png" />
</div>

#### Brute - 

```java

```
>Time Complexity - 

>Space Complexity - 
#### Explanation

-

#### Steps

-


#### Optimal -

```java
class Node {
    int val;
    Node next;
    Node random;

    Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyListWithRandomPointer {
    public static void main(String[] args) {
        int[][] input = {
                { 7, -1 },
                { 13, 0 },
                { 11, 4 },
                { 10, 2 },
                { 1, 0 }
        };

        Node head = createLinkedList(input);
        System.out.println("OriginalList - ");
        printList(head);
        Node copy = copyRandomList(head);
        System.out.println("CopyList - ");
        printList(copy);
    }

    public static Node copyRandomList(Node head) {
        if(head==null)
            return null;

        // Interleave the original list with its copy
        Node current = head;
        while (current != null) {
            Node copy = new Node(current.val);
            copy.next = current.next;
            current.next = copy;
            current = copy.next;
        }

        // Assign random pointers for the copies
        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }

        // Restore the original list and separate the copied list
        Node original = head;
        Node copyHead = head.next;
        Node copy = copyHead;
        while (original != null) {
            original.next = original.next.next;
            if (copy.next != null) {
                copy.next = copy.next.next;
            }
            original = original.next;
            copy = copy.next;
        }
        return copyHead;
    }

    public static Node createLinkedList(int[][] data) {
        if (data == null || data.length == 0)
            return null;

        // Step 1: Create all nodes and store them in a list for random pointer access
        ArrayList<Node> nodes = new ArrayList<>();
        for (int[] pair : data) {
            nodes.add(new Node(pair[0]));
        }

        // Step 2: Set next pointers
        for (int i = 0; i < nodes.size() - 1; i++) {
            nodes.get(i).next = nodes.get(i + 1);
        }

        // Step 3: Set random pointers
        for (int i = 0; i < data.length; i++) {
            int randomIndex = data[i][1];
            nodes.get(i).random = randomIndex != -1 ? nodes.get(randomIndex) : null;
        }

        // Return the head of the list
        return nodes.get(0);
    }

    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print("[" + current.val + ", ");
            System.out.print(current.random != null ? current.random.val : "null");
            System.out.print("] -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
```
>Time Complexity - O(n)
- n is number of nodes.

>Space Complexity - O(1)
#### Explanation

-

#### Steps

-

#### Follow up 

-

## **Add Two Numbers**
<div align="center">
  <img alt="image" src="assets/Screenshot 2024-12-26 162331.png" />
</div>

#### Brute - 

```java

```
>Time Complexity - 

>Space Complexity - 
#### Explanation

-

#### Steps

-


#### Optimal -

```java
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
```
>Time Complexity - 

>Space Complexity - 
#### Explanation

-

#### Steps

-

#### Follow up 

-

## **Find the Duplicate Number**
<div align="center">
  <img alt="image" src="assets/Screenshot 2024-12-27 115743.png" />
</div>

#### Brute - 

```java
public class FindDuplicateInteger {
    public static void main(String[] args) {
        int[] nums = { 1, 3, 4, 2, 2 };
        System.out.println(findDuplicateIntegerBrute(nums));
    }

    private static int findDuplicateIntegerBrute(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }
        return 0;
    }
}
```
>Time Complexity - O(n^2)

>Space Complexity - O(1)
#### Explanation

-


#### Optimal -

```java
public class FindDuplicateInteger {
    public static void main(String[] args) {
        int[] nums = { 1, 3, 4, 2, 2 };
        System.out.println(findDuplicateIntegerOptimal(nums));
    }

    private static int findDuplicateIntegerOptimal(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        // Detect Cycle
         do {
            slow = nums[slow];       // Move slow pointer by 1 step
            fast = nums[nums[fast]]; // Move fast pointer by 2 steps
        } while (slow != fast);

        // Find duplicate
        int slow2 = nums[0];
        slow = nums[0]; // Reset slow to the start
        while (slow != fast) {
            slow = nums[slow]; // Move both pointers one step
            fast = nums[fast];
        }
        return slow;
    }
}
```
>Time Complexity - O(n)

>Space Complexity - O(1)
#### Explanation

- Floyds cycle detection algorithm

#### Steps

-

#### Follow up 

-

#### Optimal -

```java
public class FindDuplicateInteger {
    public static void main(String[] args) {
        int[] nums = { 1, 3, 4, 2, 2 };
        System.out.println(findDuplicateIntegerOptimal(nums));
    }

    private static int findDuplicateIntegerOptimal(int[] nums) {
        int slow =0;
        int fast = 0;

        while(true){
            slow = nums[slow]; // Move slow pointer by 1 step
            fast = nums[nums[fast]]; // Move fast pointer by 2 steps
            if(fast==slow)
            break;
        }
           

        // Find duplicate
        int slow2 = 0;
        while (true) {
            slow = nums[slow]; // Move both pointers one step
            slow2 = nums[slow2];
            if(slow==slow2){
                return slow;
            }
        }
    }
}
```
>Time Complexity - O(n)

>Space Complexity - O(1)
#### Explanation

- Floyds cycle detection algorithm

#### Steps

-

#### Follow up 

-